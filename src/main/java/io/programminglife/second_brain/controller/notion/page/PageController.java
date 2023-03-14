package io.programminglife.second_brain.controller.notion.page;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.programminglife.second_brain.service.interfaces.notion.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.UUID;

@RestController
public class PageController {

    @Autowired
    private PageService pageService;


    @RequestMapping(value = "/page")
    public ResponseEntity<Object> getPage(@RequestParam String pageId) {
        try {
            return new ResponseEntity<>(pageService.getPage(UUID.fromString(pageId)), HttpStatus.OK);
        } catch (URISyntaxException | JsonProcessingException e) {
            // TODO proper error handling to display error message
            throw new RuntimeException(e);
        }
    }

}
