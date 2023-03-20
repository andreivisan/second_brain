package io.programminglife.second_brain.service.interfaces.notion.database;

import io.programminglife.second_brain.model.notion.database.Database;

import java.net.URISyntaxException;

// Service class to interact with Notion Database API
public interface DatabaseService {

    // Get database from Notion using DB id
    // Used to get database details in order to retrieve all page ids for a DB
    public abstract Database getDatabase(String databaseId) throws URISyntaxException;

}
