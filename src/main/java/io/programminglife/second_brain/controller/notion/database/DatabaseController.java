package io.programminglife.second_brain.controller.notion.database;

import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
public class DatabaseController {

    private DatabaseService databaseService;


    @RequestMapping(value = "/database")
    public ResponseEntity<Object> getDatabase(@RequestParam String databaseId) {
        try {
            return new ResponseEntity<>(databaseService.getDatabase(databaseId), HttpStatus.OK);
        } catch (URISyntaxException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while retrieving page due to invalid Notion URI", e);
        }
    }

}
