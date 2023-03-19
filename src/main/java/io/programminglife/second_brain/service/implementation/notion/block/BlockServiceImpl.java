package io.programminglife.second_brain.service.implementation.notion.block;

import io.programminglife.second_brain.model.notion.block.Block;
import io.programminglife.second_brain.model.notion.page.Page;
import io.programminglife.second_brain.service.interfaces.notion.block.BlockService;
import io.programminglife.second_brain.util.NotionRequestUtil;
import org.springframework.beans.factory.annotation.Value;
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
    public Page getBlocksForPage(String pageId) throws URISyntaxException {
        String notionApiDbUrl = String.format("%s/blocks/%s/children", notionApiBaseUrl, pageId);
        URI databaseUri = new URI(notionApiDbUrl);
        NotionRequestUtil notionRequestUtil = new NotionRequestUtil();

        return notionRequestUtil.get(notionApiToken, notionApiNotionVersion, databaseUri.toString(), Page.class);
    }
}
