package io.programminglife.second_brain.controller.database;

import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
import io.programminglife.second_brain.util.FileUtil;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        String database = FileUtil.getJsonFileContent("/json/database.json");
        when(databaseService.getDatabase()).thenReturn(database);

        mockMvc.perform(get("/database"))
                .andExpect(status().isOk())
                .andExpect(content().json(database));

        verify(databaseService, times(1)).getDatabase();
    }

}
