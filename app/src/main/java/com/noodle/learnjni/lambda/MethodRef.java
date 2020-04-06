package com.noodle.learnjni.lambda;

/**
 * @author heshufan
 * @date 2020-03-05
 */
public class MethodRef {
    public static void main(String... args) {
        double a = 1.3;
        //自己定义的Lambda表达式
        System.out.println(worker((m) -> m + 1, a));

        //方法引用，应用的是系统库的函数
        System.out.println(worker(Math::abs, a));
        System.out.println(worker(Math::floor, a));
    }

    interface NumFunction {
        double calculate(double m);
    }

    public static double worker(NumFunction numFunction, double c) {
        return numFunction.calculate(c);
    }

    //1、Math::abs方法会填充到NumFunction的calculate方法
    //2、产生一个NumFunction子类型对象传递到worker里面的参数
    //3、执行NumFunction子类型对象的calculate方法
}
