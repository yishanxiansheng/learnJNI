package com.noodle.learnjni.builder;

import android.icu.lang.UScript;

/**
 * @author heshufan
 * @date 2020-02-11
 */
public class User {
    private String name;
    private int age;
    private String sex;
    private String company;

    public static void main(String... args){
        User user = new UserBuilder().setAge(3)
                .setCompany("a")
                .setName("hha")
                .build();
    }

    public User(UserBuilder buidler) {
        this.name = buidler.name;
        this.age = buidler.age;
        this.sex = buidler.sex;
        this.company = buidler.company;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getCompany() {
        return company;
    }
}
