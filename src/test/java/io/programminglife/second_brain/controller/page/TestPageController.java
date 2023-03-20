package io.programminglife.second_brain.controller.page;

import io.programminglife.second_brain.model.notion.page.Page;
import io.programminglife.second_brain.service.interfaces.notion.page.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestPageController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PageService pageService;


    @Test
    public void testGetDatabase() throws Exception {
        when(pageService.getPage(any())).thenReturn(new Page());

        mockMvc.perform(get("/page?pageId=710f10f9-c700-4f78-bacf-d6a4ebc39ba4"))
                .andExpect(status().isOk());

        verify(pageService, times(1)).getPage(any());
    }

}
