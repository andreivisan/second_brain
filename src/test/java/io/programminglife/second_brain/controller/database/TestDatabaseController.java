package io.programminglife.second_brain.controller.database;

import io.programminglife.second_brain.model.notion.database.Database;
import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestDatabaseController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DatabaseService databaseService;


    @Test
    public void testGetDatabase() throws Exception {
        when(databaseService.getDatabase(anyString())).thenReturn(new Database());

        mockMvc.perform(get("/database?databaseId=123"))
                .andExpect(status().isOk());

        verify(databaseService, times(1)).getDatabase(any());
    }

}
