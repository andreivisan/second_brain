package io.programminglife.second_brain.controller.block;

import io.programminglife.second_brain.model.notion.block.PageBlocks;
import io.programminglife.second_brain.service.interfaces.notion.block.BlockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class TestBlockController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlockService blockService;


    @Test
    public void testGetDatabase() throws Exception {
        PageBlocks pageBlocks = new PageBlocks();
        when(blockService.getBlocksForPage(anyString())).thenReturn(pageBlocks);

        mockMvc.perform(get("/blocksForPage?pageId=123"))
                .andExpect(status().isOk());

        verify(blockService, times(1)).getBlocksForPage(any());
    }

}
