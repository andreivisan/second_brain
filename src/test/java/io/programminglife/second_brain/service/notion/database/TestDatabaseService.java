package io.programminglife.second_brain.service.notion.database;

import io.programminglife.second_brain.service.interfaces.notion.database.DatabaseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.UUID;

            import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TestDatabaseService {

    @Autowired
    private DatabaseService databaseService;

    private String databaseResult;


    @Before
    public void setUp() throws Exception {
        databaseResult = databaseService.getDatabase("6a99221c7c904cc493e03e7bd100b711");
    }

    @Test
    public void testGetDatabase() {
        assertThat(this.databaseResult).isNotEmpty();
    }

    @Test
    public void testGetDatabasePageIds() throws Exception {
        Set<UUID> databasePageIds = databaseService.getDatabasePageIds(this.databaseResult);

        assertThat(databasePageIds).isNotEmpty();
        assertThat(databasePageIds.size()).isEqualTo(71);
    }

}
