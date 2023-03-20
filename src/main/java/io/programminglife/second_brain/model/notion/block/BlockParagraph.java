package io.programminglife.second_brain.model.notion.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlockParagraph {

    @JsonProperty("rich_text")
    private List<BlockRichText> richText;

    @JsonProperty("bulleted_list_items")
    private List<BlockRichText> bulletedListItems;

}
