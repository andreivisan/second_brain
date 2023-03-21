package io.programminglife.second_brain.model.notion.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Block implements Serializable {

    private String type;

    private BlockImage image;

    private BlockParagraph paragraph;

    @JsonProperty("numbered_list_item")
    private BlockParagraph numberedListItem;

    @JsonProperty("bulleted_list_item")
    private BlockParagraph bulletedListItem;

}
