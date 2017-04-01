package com.score.api.dto;

import java.util.List;

/**
 * Created by cheng on 16/12/13.
 */
public class TableDescDto {

    private String table;

    private List<FieldDescDto> fields;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<FieldDescDto> getFields() {
        return fields;
    }

    public void setFields(List<FieldDescDto> fields) {
        this.fields = fields;
    }
}
