package com.example.mybatisdemo.entity;

import javax.persistence.*;

@Table(name = "test_user")
public class TestUser {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别（0为男，1为女）
     */
    private String gender;

    /**
     * 用户编号
     */
    @Column(name = "user_number")
    private Integer userNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别（0为男，1为女）
     *
     * @return gender - 性别（0为男，1为女）
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别（0为男，1为女）
     *
     * @param gender 性别（0为男，1为女）
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取用户编号
     *
     * @return user_number - 用户编号
     */
    public Integer getUserNumber() {
        return userNumber;
    }

    /**
     * 设置用户编号
     *
     * @param userNumber 用户编号
     */
    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}