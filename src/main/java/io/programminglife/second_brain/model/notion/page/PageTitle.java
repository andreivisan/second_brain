package io.programminglife.second_brain.model.notion.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageTitle {

    @JsonProperty("plain_text")
    private String plainText;

}
