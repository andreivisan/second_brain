package io.programminglife.second_brain.service.interfaces.notion.page;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.programminglife.second_brain.model.notion.page.Note;

import java.net.URISyntaxException;
import java.util.Optional;
import java.util.UUID;

public interface PageService {

    public abstract Optional<Note> getPage(UUID pageId) throws URISyntaxException, JsonProcessingException;

}
