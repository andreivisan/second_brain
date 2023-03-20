package io.programminglife.second_brain.service.interfaces.notion.block;

import io.programminglife.second_brain.model.notion.block.PageBlocks;

import java.net.URISyntaxException;

public interface BlockService {

    public abstract PageBlocks getBlocksForPage(String pageId) throws URISyntaxException;

}
