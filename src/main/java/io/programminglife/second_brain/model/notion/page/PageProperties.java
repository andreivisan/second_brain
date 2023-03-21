package io.programminglife.second_brain.model.notion.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PageProperties {

    @JsonProperty("URL")
    private PageUrl url;

    @JsonProperty("﻿Name")
    private PageName pageName;

}
