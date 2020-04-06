package com.noodle.learnjni.proxy.multiInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author heshufan
 * @date 2020-02-22
 */
public class CookHandler implements InvocationHandler {
    private Cook cook;
    public CookHandler(Cook cook){
        this.cook = cook;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(cook,args);
    }
}
