package com.noodle.learnjni.enums;

/**
 * @author heshufan
 * @date 2020-02-16
 */
public class Test {

    public Test() {
        Week week = Week.Monday;

        if (week.equals(Week.Monday)){
            System.out.println("Today is Monday");
        }
    }
}
