package io.programminglife.second_brain.service.implementation.notion.block;

import io.programminglife.second_brain.model.notion.block.PageBlocks;
import io.programminglife.second_brain.service.interfaces.notion.block.BlockService;
import io.programminglife.second_brain.util.NotionRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class BlockServiceImpl implements BlockService {

    @Value("${notion.api.token}")
    private String notionApiToken;

    @Value("${notion.api.base.url}")
    private String notionApiBaseUrl;

    @Value("${notion.api.notion.version}")
    private String notionApiNotionVersion;


    @Override
    @Cacheable("blocksForPageCache")
    public PageBlocks getBlocksForPage(String pageId) throws URISyntaxException {
        String notionApiDbUrl = String.format("%s/blocks/%s/children", notionApiBaseUrl, pageId);
        URI databaseUri = new URI(notionApiDbUrl);
        NotionRequestUtil notionRequestUtil = new NotionRequestUtil();

        return notionRequestUtil.get(notionApiToken, notionApiNotionVersion, databaseUri.toString(), PageBlocks.class);
    }
}
