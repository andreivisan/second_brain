package io.programminglife.second_brain.service.interfaces.notion.block;

import io.programminglife.second_brain.model.notion.block.Block;
import io.programminglife.second_brain.model.notion.page.Page;

import java.net.URISyntaxException;

public interface BlockService {

    public abstract Page getBlocksForPage(String pageId) throws URISyntaxException;

}
