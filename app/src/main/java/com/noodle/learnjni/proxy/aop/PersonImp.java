package com.noodle.learnjni.proxy.aop;

import java.lang.reflect.Proxy;

/**
 * @author heshufan
 * @date 2020-02-23
 */
public class PersonImp implements Person {
    @Override
    public void washHand() {
        System.out.println("wash hand");
    }

    @Override
    public void eat() {
        System.out.println("eat");

    }

    @Override
    public void sleep() {
        System.out.println("sleep");
    }


    public static void main(String[] args){
        PersonImp personImp = new PersonImp();
        PersonHandler handler = new PersonHandler(personImp);
        //todo 读取配置文件
        Person person = (Person) Proxy.newProxyInstance(PersonImp.class.getClassLoader(),PersonImp.class.getInterfaces(),handler);
        person.sleep();
    }
}
