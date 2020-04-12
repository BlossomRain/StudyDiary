package com.test.bean;

import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;

/**
 * @Auther: lxz
 * @Date: 2020/3/26 0026
 * @Description:对应数据库中的一张表
 */
public class Customer {

    private int id;
    private String name;
    private String address;
    private String phone;
    private Date birth;
    private Blob photo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(birth, customer.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, birth);
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Customer() {
    }

    public Customer(int id, String name, String address, String phone, Date birth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birth = birth;
    }
}
