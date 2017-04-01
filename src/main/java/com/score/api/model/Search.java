package com.score.api.model;

/**
 * Created by cheng on 16/12/13.
 */
public class Search {

    private Integer id;

    private String name;

    private String val;

    private String is_view;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getIs_view() {
        return is_view;
    }

    public void setIs_view(String is_view) {
        this.is_view = is_view;
    }
}
