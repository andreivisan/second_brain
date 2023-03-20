package io.programminglife.second_brain.model.notion.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageProperties {

    @JsonProperty("URL")
    private PageUrl url;

    @JsonProperty("﻿Name")
    private PageName pageName;

}
