package io.programminglife.second_brain.model.notion.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BlockRichText implements Serializable {

    @JsonProperty("plain_text")
    private String plainText;

    private BlockStyle annotations;

    private String href;

}
