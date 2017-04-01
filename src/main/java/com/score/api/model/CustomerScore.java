package com.score.api.model;

/**
 * Created by cheng on 2017/1/1.
 */
public class CustomerScore {

    private Integer id;

    private Integer customer_id;

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

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
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
}
