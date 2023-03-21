package io.programminglife.second_brain.model.notion.block;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageBlocks implements Serializable {

    @JsonProperty("results")
    private List<Block> pageBlocks;

}
