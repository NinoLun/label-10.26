package com.score.api.dto;

/**
 * Created by cheng on 2017/1/1.
 */
public class CustomerDto {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 客户标识
     */
    private Integer client_id;

    private String name;

    private String area;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0女,1男
     */
    private Integer gender;

    /**
     * 学历
     */
    private Integer degree;

    /**
     * 年收入
     */
    private double year_income;

    /**
     * 资金开户时间
     */
    private String fund_open_date;


    /**
     * 交易账户
     */
    private String trade_account;


    /**
     * 促活分
     */
    private double activate_score;
    /**
     * 产品一分
     */
    private double product1_score;

    /**
     * 产品2分
     */
    private double product2_score;
    /**
     * 产品3分
     */
    private double product3_score;

    /**
     * 流失分
     */
    private double churn_score;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public double getYear_income() {
        return year_income;
    }

    public void setYear_income(double year_income) {
        this.year_income = year_income;
    }

    public String getFund_open_date() {
        return fund_open_date;
    }

    public void setFund_open_date(String fund_open_date) {
        this.fund_open_date = fund_open_date;
    }

    public String getTrade_account() {
        return trade_account;
    }

    public void setTrade_account(String trade_account) {
        this.trade_account = trade_account;
    }

    public double getActivate_score() {
        return activate_score;
    }

    public void setActivate_score(double activate_score) {
        this.activate_score = activate_score;
    }

    public double getProduct1_score() {
        return product1_score;
    }

    public void setProduct1_score(double product1_score) {
        this.product1_score = product1_score;
    }

    public double getProduct2_score() {
        return product2_score;
    }

    public void setProduct2_score(double product2_score) {
        this.product2_score = product2_score;
    }

    public double getProduct3_score() {
        return product3_score;
    }

    public void setProduct3_score(double product3_score) {
        this.product3_score = product3_score;
    }

    public double getChurn_score() {
        return churn_score;
    }

    public void setChurn_score(double churn_score) {
        this.churn_score = churn_score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
