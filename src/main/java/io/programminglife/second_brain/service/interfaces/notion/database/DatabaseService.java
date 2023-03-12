package io.programminglife.second_brain.service.interfaces.notion.database;

import java.net.URISyntaxException;
import java.util.UUID;

// Service class to interact with Notion Database API
public interface DatabaseService {

    // Get database from Notion using DB id
    // Used to get database details in order to retrieve all page ids for a DB
    public abstract String getDatabase() throws URISyntaxException;

}
