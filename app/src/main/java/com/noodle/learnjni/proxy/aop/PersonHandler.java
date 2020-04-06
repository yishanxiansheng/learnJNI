package com.noodle.learnjni.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author heshufan
 * @date 2020-02-23
 */
public class PersonHandler implements InvocationHandler {
    /**
     * 执行方法前必须执行的方法
     */
    static String beforeMethod;

    /**
     * 执行方法后必须执行的方法
     */
    static String afterMethod;

    private Person person;

    public PersonHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (beforeMethod != null){
            ClassLoader loader = PersonHandler.class.getClassLoader();
            Class obj = loader.loadClass(person.getClass().getName());
            Method method1 = obj.getMethod(beforeMethod);
            Object o = obj.newInstance();
            method1.invoke(o,null);
        }

        Object result = method.invoke(person,args);

        if (afterMethod != null){
            ClassLoader loader = PersonHandler.class.getClassLoader();
            Class obj = loader.loadClass(person.getClass().getName());
            Object object = obj.newInstance();
            Method after = obj.getMethod(afterMethod,null);
            after.invoke(object,null);
        }
        return result;
    }
}
