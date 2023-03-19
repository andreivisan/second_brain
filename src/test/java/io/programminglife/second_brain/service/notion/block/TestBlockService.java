package io.programminglife.second_brain.service.notion.block;

import io.programminglife.second_brain.model.notion.block.Block;
import io.programminglife.second_brain.model.notion.page.Page;
import io.programminglife.second_brain.service.interfaces.notion.block.BlockService;
import org.junit.Before;
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
public class TestBlockService {

    @Autowired
    private BlockService blockService;

    private Page page;

    @Before
    public void setUp() throws Exception {
        page = blockService.getBlocksForPage(("710f10f9-c700-4f78-bacf-d6a4ebc39ba4"));
    }

    @Test
    public void testGetBlockForPage() {
        assertThat(this.page).isNotNull();
        assertThat(this.page.getParagraphs()).isNotEmpty();
        assertThat(this.page.getParagraphs().size()).isGreaterThan(0);
    }

}
