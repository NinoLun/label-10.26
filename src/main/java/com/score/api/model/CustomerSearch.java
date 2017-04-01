package com.score.api.model;

/**
 * Created by cheng on 2017/1/1.
 */
public class CustomerSearch {

    /**
     * 主键id
     */
    private Integer id;

    private Integer degree;

    private Integer gender;

    private Double year_income;

    private String score_field;

    private String score_sector;

    private String create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getYear_income() {
        return year_income;
    }

    public void setYear_income(Double year_income) {
        this.year_income = year_income;
    }

    public String getScore_field() {
        return score_field;
    }

    public void setScore_field(String score_field) {
        this.score_field = score_field;
    }

    public String getScore_sector() {
        return score_sector;
    }

    public void setScore_sector(String score_sector) {
        this.score_sector = score_sector;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
