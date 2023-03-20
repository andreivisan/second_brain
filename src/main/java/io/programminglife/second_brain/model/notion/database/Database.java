package io.programminglife.second_brain.model.notion.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Database {

    @JsonProperty("results")
    private List<DatabasePage> pages;

}
