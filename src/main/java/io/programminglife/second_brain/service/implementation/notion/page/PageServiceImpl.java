package io.programminglife.second_brain.service.implementation.notion.page;

import io.programminglife.second_brain.model.notion.page.Page;
import io.programminglife.second_brain.service.interfaces.notion.page.PageService;
import io.programminglife.second_brain.util.NotionRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Service
public class PageServiceImpl implements PageService {

    @Value("${notion.api.token}")
    private String notionApiToken;

    @Value("${notion.api.base.url}")
    private String notionApiBaseUrl;

    @Value("${notion.api.notion.version}")
    private String notionApiNotionVersion;


    @Override
    public Page getPage(UUID pageId) throws URISyntaxException {
        String notionAPIPageUrl = String.format("%s/pages/%s", notionApiBaseUrl, pageId);
        URI pageUri = new URI(notionAPIPageUrl);
        NotionRequestUtil notionRequestUtil = new NotionRequestUtil();

        return notionRequestUtil.get(notionApiToken, notionApiNotionVersion, pageUri.toString(), Page.class);
    }
}
