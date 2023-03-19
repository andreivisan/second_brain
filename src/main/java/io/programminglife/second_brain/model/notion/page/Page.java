package io.programminglife.second_brain.model.notion.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.programminglife.second_brain.model.notion.block.Block;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Page {

    @JsonProperty("results")
    private List<Block> paragraphs;

}
