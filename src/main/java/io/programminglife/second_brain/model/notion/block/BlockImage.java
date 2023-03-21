package io.programminglife.second_brain.model.notion.block;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlockImage implements Serializable {

    private ImageFile file;

}
