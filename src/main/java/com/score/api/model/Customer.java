package com.score.api.model;

/**
 * Created by cheng on 2017/1/1.
 */
public class Customer {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 客户标识
     */
    private Integer client_id;


    /**
     *名称
     */

    private String name;


    /**
     * 区域
     */
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


    private String stock_open_date;

    /**
     * 份额账户
     */
    private String stock_account;

    /**
     * 银行账户
     */
    private String fund_bank_account;

    /**
     * 资金账户
     */
    private String fund_account;

    /**
     * 交易账户
     */
    private String trade_account;


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

    public String getStock_open_date() {
        return stock_open_date;
    }

    public void setStock_open_date(String stock_open_date) {
        this.stock_open_date = stock_open_date;
    }

    public String getStock_account() {
        return stock_account;
    }

    public void setStock_account(String stock_account) {
        this.stock_account = stock_account;
    }

    public String getFund_bank_account() {
        return fund_bank_account;
    }

    public void setFund_bank_account(String fund_bank_account) {
        this.fund_bank_account = fund_bank_account;
    }

    public String getFund_account() {
        return fund_account;
    }

    public void setFund_account(String fund_account) {
        this.fund_account = fund_account;
    }

    public String getTrade_account() {
        return trade_account;
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

    public void setTrade_account(String trade_account) {
        this.trade_account = trade_account;
    }
}
