package io.programminglife.second_brain.model.notion.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockRichText {

    @JsonProperty("plain_text")
    private String plainText;
    private BlockStyle annotations;

}
