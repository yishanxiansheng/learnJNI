package com.noodle.learnjni.genericity;

/**
 * @author heshufan
 * @date 2020-02-16
 */
public class GenericityIntfcImp implements GenericityInterface<String> {

    public static void main(String... args){
        //todo
    }
    @Override
    public String getValue() {
        return null;
    }

    /**
     * 通配符进行上限的限定
     * @param genricityClass
     */
    public void limitUpper(GenricityClass< ? extends String> genricityClass){

    }

    /**
     * 不使用通配符进行上限的限定
     * @param genricityClass
     */
    public  <T extends String> void  limitUpper2(GenricityClass< T> genricityClass){

    }
}
