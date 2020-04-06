package com.noodle.learnjni.proxy;

import android.animation.ObjectAnimator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器对象
 * @author heshufan
 * @date 2020-02-22
 */
public class SubjectHandler implements InvocationHandler {

    private Subject subject;

    public SubjectHandler(Subject subject){
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = method.invoke(subject,args);
        return object;
    }
}
