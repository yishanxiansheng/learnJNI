package com.noodle.learnjni.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author heshufan
 * @date 2020-03-05
 */
public class Main {
    public static void main(String... args) {
        String[] strings = new String[]{"a", "ss", "ddd", "gggg"};

        //从大到小排序
        Arrays.sort(strings, new LengthComparator());
        Arrays.sort(strings,(String first,String second) -> first.length() - second.length());

        //lambda自动识别需要转化为的对象
        //lambda表达式（匿名函数）自动成为接口的实现
        Comparator<String> comparator = (String first,String second)->first.length()-second.length();
        Arrays.sort(strings,comparator);

        //从小到大排序
        Arrays.sort(strings, new LengthReComparator());
        Arrays.sort(strings,(String first,String second) -> -1*(first.length() - second.length()));

        //使用嵌套类
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int legth1 = o1 != null ? 0 : o1.length();
                int legth2 = o1 != null ? 0 : o2.length();
                return -1*(legth1 - legth2);
            }
        });

        //方法引用
        Arrays.sort(strings,String::compareToIgnoreCase);

        System.out.println("he");
    }


    /**
     * 字符串长度比较器 从大到小排序
     */
    public static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int legth1 = o1 != null ? 0 : o1.length();
            int legth2 = o1 != null ? 0 : o2.length();
            return legth1 - legth2;
        }
    }

    /**
     * 字符串长度比较器 从大到小排序
     */
    public static class LengthReComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int legth1 = o1 != null ? 0 : o1.length();
            int legth2 = o1 != null ? 0 : o2.length();
            return -1*(legth1 - legth2);
        }
    }
}
