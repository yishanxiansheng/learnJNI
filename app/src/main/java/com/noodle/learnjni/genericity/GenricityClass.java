package com.noodle.learnjni.genericity;

/**
 * 泛型类
 * @author heshufan
 * @date 2020-02-16
 */
public class GenricityClass<K> {
    private K value;

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }
}
