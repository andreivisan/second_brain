package io.programminglife.second_brain.model.notion.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Database {

    @JsonProperty("results")
    private List<DatabasePage> pages;

}
