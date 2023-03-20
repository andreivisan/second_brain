package io.programminglife.second_brain.model.notion.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Block {

    private String type;

    private BlockImage image;

    private BlockParagraph paragraph;

    @JsonProperty("numbered_list_item")
    private BlockParagraph numberedListItem;

    @JsonProperty("bulleted_list_item")
    private BlockParagraph bulletedListItem;

}
