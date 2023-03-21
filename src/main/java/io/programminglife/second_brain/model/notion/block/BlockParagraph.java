package io.programminglife.second_brain.model.notion.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BlockParagraph implements Serializable {

    @JsonProperty("rich_text")
    private List<BlockRichText> richText;

}
