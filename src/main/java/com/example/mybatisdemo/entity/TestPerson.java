package com.example.mybatisdemo.entity;

import javax.persistence.*;

@Table(name = "test_person")
public class TestPerson {
    @Id
    @Column(name = "test_id")
    private Integer testId;

    /**
     * 用户名
     */
    @Column(name = "test_name")
    private String testName;

    /**
     * 电话号码
     */
    @Column(name = "test_phone")
    private String testPhone;

    /**
     * @return test_id
     */
    public Integer getTestId() {
        return testId;
    }

    /**
     * @param testId
     */
    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    /**
     * 获取用户名
     *
     * @return test_name - 用户名
     */
    public String getTestName() {
        return testName;
    }

    /**
     * 设置用户名
     *
     * @param testName 用户名
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * 获取电话号码
     *
     * @return test_phone - 电话号码
     */
    public String getTestPhone() {
        return testPhone;
    }

    /**
     * 设置电话号码
     *
     * @param testPhone 电话号码
     */
    public void setTestPhone(String testPhone) {
        this.testPhone = testPhone;
    }
}