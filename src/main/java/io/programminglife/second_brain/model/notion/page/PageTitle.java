package io.programminglife.second_brain.model.notion.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PageTitle {

    @JsonProperty("plain_text")
    private String plainText;

}
