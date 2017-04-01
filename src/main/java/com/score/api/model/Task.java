package com.score.api.model;

/**
 * Created by cheng on 2017/3/20.
 */
public class Task {

    private Integer id;

    private String name;

    private String work_time;

    private String create_time;

    private String score_field;

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

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getScore_field() {
        return score_field;
    }

    public void setScore_field(String score_field) {
        this.score_field = score_field;
    }
}
