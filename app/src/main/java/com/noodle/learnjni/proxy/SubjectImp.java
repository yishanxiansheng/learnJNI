package com.noodle.learnjni.proxy;

import java.lang.reflect.Proxy;

/**
 * @author heshufan
 * @date 2020-02-22
 */
public class SubjectImp implements Subject {
    @Override
    public void get() {
        System.out.println("Get");
    }

    public static void main(String[] args){
        //1、创建对象
        SubjectImp subjectImp = new SubjectImp();

        //2、创建调用处理器对象
        SubjectHandler handler = new SubjectHandler(subjectImp);

        //3、动态生成代理对象 代理对象实现了一个接口
        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                SubjectImp.class.getInterfaces(),handler);

        //4、代理对象执行方法
        subject.get();
    }
}
