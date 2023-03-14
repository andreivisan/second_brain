package io.programminglife.second_brain.service.interfaces.notion.database;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.URISyntaxException;
import java.util.Set;
import java.util.UUID;

// Service class to interact with Notion Database API
public interface DatabaseService {

    // Get database from Notion using DB id
    // Used to get database details in order to retrieve all page ids for a DB
    public abstract String getDatabase(String databaseId) throws URISyntaxException;

    // Get all page ids for a DB
    public abstract Set<UUID> getDatabasePageIds(String databaseJson) throws JsonProcessingException;

}
