package io.programminglife.second_brain.service.notion.page;

import io.programminglife.second_brain.model.notion.page.Page;
import io.programminglife.second_brain.service.interfaces.notion.page.PageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TestPageServiceBlocks {

    @Autowired
    private PageService pageService;

    private Page pageResult;

    @Before
    public void setUp() throws Exception {
        this.pageResult = pageService.getPage(UUID.fromString("710f10f9-c700-4f78-bacf-d6a4ebc39ba4"));
    }

    @Test
    public void testGetPage() {
        assertThat(this.pageResult).isNotNull();
    }

}
