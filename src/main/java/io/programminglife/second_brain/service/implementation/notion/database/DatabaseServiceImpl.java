package io.programminglife.second_brain.service.implementation.notion.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
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

    private static final String NOTION_VERSION_HEADER_PARAM = "Notion-Version";

    @Value("${notion.api.token}")
    private String notionApiToken;

    @Value("${notion.api.base.url}")
    private String notionApiBaseUrl;

    @Value("${notion.api.notion.version}")
    private String notionApiNotionVersion;

    @Value("${notion.db.quick.notes.id}")
    private String notionDbQuickNotesId;


    // TODO pass in the DB uuid and move the Notion Database id to the controller
    @Override
    public String getDatabase() throws URISyntaxException {
        String notionApiDbUrl = String.format("%s/databases/%s/query", notionApiBaseUrl, notionDbQuickNotesId);
        URI databaseUri = new URI(notionApiDbUrl);

        RestTemplate restTemplate = new RestTemplate();

        // this is a POST request, so we are setting up the headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.setBearerAuth(notionApiToken);
        requestHeaders.set(NOTION_VERSION_HEADER_PARAM, notionApiNotionVersion);

        // TODO we will send empty request body to start with
        HttpEntity<String> httpEntity = new HttpEntity<>("", requestHeaders);

        // retrieve the result
        ResponseEntity<String> databaseResult = restTemplate.postForEntity(databaseUri, httpEntity, String.class);

        return databaseResult.getBody();
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
