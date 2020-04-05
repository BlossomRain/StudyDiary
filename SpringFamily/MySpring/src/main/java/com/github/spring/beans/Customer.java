package com.github.spring.beans;

import java.sql.Date;

/**
 * @Auther: lxz
 * @Date: 2020/4/5 0005
 * @Description:对应数据库中的customers表
 */
public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Date birth;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                '}';
    }

    public Customer(String name, String address, String phone, Date birth) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birth = birth;
    }

    public Customer() {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
