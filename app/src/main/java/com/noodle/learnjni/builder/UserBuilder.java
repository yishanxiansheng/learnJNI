package com.noodle.learnjni.builder;

/**
 * @author heshufan
 * @date 2020-02-11
 */
public class UserBuilder {
    public String name;
    public int age;
    public String sex;
    public String company;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public UserBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    public User build() {
        return new User(this);
    }

}
