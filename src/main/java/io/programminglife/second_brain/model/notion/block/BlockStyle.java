package io.programminglife.second_brain.model.notion.block;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlockStyle implements Serializable {

    private boolean bold;

    private boolean italic;

    private boolean underline;

}
