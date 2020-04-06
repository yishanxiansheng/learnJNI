package com.noodle.learnjni.proxy.multiInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author heshufan
 * @date 2020-02-22
 */
public class CookImp implements Cook {
    @Override
    public void doWork() {
        System.out.println("cook doWork");
    }

    public static void main(String[] args) {
        //代理对象实现多个接口

        //1、创建对象
        CookImp cookImp = new CookImp();

        //2、生成代理处理器
        CookHandler handler = new CookHandler(cookImp);

        //3、生成代理对象，这个对象不仅实现了Cook接口，也实现了Driver接口

        //3.1 生成代理类型
        Class<?> proxyClass = Proxy.getProxyClass(CookImp.class.getClassLoader(),
                new Class<?>[]{Cook.class, Driver.class});

        //3.2 生成代理对象
        try {
            //proxy 实现了两个接口，也就是代理类实现了两个接口
            Object proxy = proxyClass.getConstructor(new Class[]{InvocationHandler.class}).newInstance(new Object[]{handler});

            Cook cook = (Cook) proxy;
            Driver driver = (Driver) proxy;

            cook.doWork();//实际执行的是Cook的doWork;
            driver.doWork();//实际执行的也是Cook的doWork 因为这里被CookHandler拦截，CookHandler里面是Cook对象

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}