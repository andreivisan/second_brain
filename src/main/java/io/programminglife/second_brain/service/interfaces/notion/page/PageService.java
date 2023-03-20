package io.programminglife.second_brain.service.interfaces.notion.page;

import io.programminglife.second_brain.model.notion.page.Page;

import java.net.URISyntaxException;
import java.util.UUID;

public interface PageService {

    public abstract Page getPage(UUID pageId) throws URISyntaxException;

}
