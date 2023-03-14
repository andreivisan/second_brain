package io.programminglife.second_brain.service.implementation.notion.page;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.programminglife.second_brain.model.notion.page.Note;
import io.programminglife.second_brain.service.interfaces.notion.page.PageService;
import io.programminglife.second_brain.util.NotionRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@Service
public class PageServiceImpl implements PageService {

    @Value("${notion.api.token}")
    private String notionApiToken;

    @Value("${notion.api.base.url}")
    private String notionApiBaseUrl;

    @Value("${notion.api.notion.version}")
    private String notionApiNotionVersion;


    @Override
    public Optional<Note> getPage(UUID pageId) throws URISyntaxException, JsonProcessingException {
        String notionAPIPageUrl = String.format("%s/pages/%s", notionApiBaseUrl, pageId);
        URI pageUri = new URI(notionAPIPageUrl);
        NotionRequestUtil notionRequestUtil = new NotionRequestUtil();

        // retrieve page in JSON format
        String pageResult = notionRequestUtil.get(notionApiToken, notionApiNotionVersion, pageUri.toString()).getBody();

        return parseJsonResponseToNote(pageResult);
    }

    // parse JSON and build Note object
    private Optional<Note> parseJsonResponseToNote(String pageResult) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(pageResult);
        JsonNode propertiesNode = rootNode.path("properties");
        JsonNode urlNode = propertiesNode.path("URL");
        JsonNode nameNode = propertiesNode.path("﻿Name");
        JsonNode titleNode = nameNode.path("title");
        Iterator<JsonNode> titleIterator = titleNode.elements();
        while (titleIterator.hasNext()) {
            JsonNode titleFirstNode = titleIterator.next();
            JsonNode titleTextNode = titleFirstNode.path("plain_text");
            if (!titleTextNode.isMissingNode()) {
                String title = titleTextNode.asText();
                String url = urlNode.isMissingNode() ? "" : urlNode.path("url").asText();
                return Optional.of(Note.builder().title(title).url(url).build());
            }
        }

        return Optional.empty();
    }
}
