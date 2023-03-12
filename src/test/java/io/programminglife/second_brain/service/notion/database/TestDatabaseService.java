package io.programminglife.second_brain.service.notion.database;

import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TestDatabaseService {

    @Autowired
    private DatabaseService databaseService;


    @Test
    public void testGetDatabase() throws Exception {
        String databaseResult = databaseService.getDatabase();

        assertThat(databaseResult).isNotEmpty();
    }

}
