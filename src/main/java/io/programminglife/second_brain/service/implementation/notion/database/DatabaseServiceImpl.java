package io.programminglife.second_brain.service.implementation.notion.database;

import io.programminglife.second_brain.model.notion.database.Database;
import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
import io.programminglife.second_brain.util.NotionRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

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
    public Database getDatabase(String databaseId) throws URISyntaxException {
        String notionApiDbUrl = String.format("%s/databases/%s/query", notionApiBaseUrl, databaseId);
        URI databaseUri = new URI(notionApiDbUrl);
        NotionRequestUtil notionRequestUtil = new NotionRequestUtil();

        return notionRequestUtil.post(notionApiToken, notionApiNotionVersion, databaseUri.toString(), Database.class);
    }

}
