package com.github.springmvc.beans;

/**
 * @Auther: lxz
 * @Date: 2020/4/6 0006
 * @Description:
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Address address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
//                ", address=" + address +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    public User(String username, String password, Integer age, Address address) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
    }
}