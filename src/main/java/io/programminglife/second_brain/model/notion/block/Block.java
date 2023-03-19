package io.programminglife.second_brain.model.notion.block;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Block {

    private String type;
    private BlockImage image;
    private BlockParagraph paragraph;

}
