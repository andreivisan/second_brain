package io.programminglife.second_brain.service.implementation.notion.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
import io.programminglife.second_brain.util.NotionRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Value("${notion.api.token}")
    private String notionApiToken;

    @Value("${notion.api.base.url}")
    private String notionApiBaseUrl;

    @Value("${notion.api.notion.version}")
    private String notionApiNotionVersion;


    // TODO pass in the DB uuid and move the Notion Database id to the controller
    @Override
    public String getDatabase(String databaseId) throws URISyntaxException {
        String notionApiDbUrl = String.format("%s/databases/%s/query", notionApiBaseUrl, databaseId);
        URI databaseUri = new URI(notionApiDbUrl);
        NotionRequestUtil notionRequestUtil = new NotionRequestUtil();

        return notionRequestUtil.post(notionApiToken, notionApiNotionVersion, databaseUri.toString()).getBody();
    }

    @Override
    public Set<UUID> getDatabasePageIds(String databaseJson) throws JsonProcessingException {
        Set<UUID> pageIds = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(databaseJson);
        JsonNode resultsNode = rootNode.path("results");
        Iterator<JsonNode> resultsIterator = resultsNode.elements();
        while(resultsIterator.hasNext()) {
            JsonNode resultNode = resultsIterator.next();
            JsonNode idNode = resultNode.path("id");
            if (!idNode.isMissingNode()) {
                pageIds.add(UUID.fromString(idNode.asText()));
            }
        }

        return pageIds;
    }


}
