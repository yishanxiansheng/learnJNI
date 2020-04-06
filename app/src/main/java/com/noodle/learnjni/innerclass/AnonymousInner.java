package com.noodle.learnjni.innerclass;

/**
 * @author heshufan
 * @date 2020-03-01
 */
public class AnonymousInner {

    //可以直接访问，也可以AnonymousInner.this.name访问，防止命名冲突
    private String name = "A time";

    public void run(){
        //想要在匿名内部类访问必须为final 修饰
         String name = "B time";

        Runnable run = new Runnable() {
            //可以直接访问
            String name = "C time";
            @Override
            public void run() {
                System.out.println(AnonymousInner.this.name);
                System.out.println(name);
            }
        };
    }
}
