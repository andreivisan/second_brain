package io.programminglife.second_brain.controller.notion.block;

import io.programminglife.second_brain.service.interfaces.notion.block.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URISyntaxException;

@Controller
public class BlockController {

    @Autowired
    private BlockService blockService;


    //TODO instead of using a query param, use a path variable
    @RequestMapping(value = "/blocksForPage")
    public ResponseEntity<Object> getDatabase(@RequestParam String pageId) {
        try {
            return new ResponseEntity<>(blockService.getBlocksForPage(pageId), HttpStatus.OK);
        } catch (URISyntaxException e) {
            // TODO proper error handling to display error message
            throw new RuntimeException(e);
        }
    }

}
