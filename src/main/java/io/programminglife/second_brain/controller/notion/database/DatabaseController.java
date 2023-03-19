package io.programminglife.second_brain.controller.notion.database;

import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;


    //TODO instead of using a query param, use a path variable
    @RequestMapping(value = "/database")
    public ResponseEntity<Object> getDatabase(@RequestParam String databaseId) {
        try {
            return new ResponseEntity<>(databaseService.getDatabase(databaseId), HttpStatus.OK);
        } catch (URISyntaxException e) {
            // TODO proper error handling to display error message
            throw new RuntimeException(e);
        }
    }

}
