package com.zel.mytest.lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

/**
 * ClassName:com.zel.mytest.lamda.TestLamda
 * Function:
 * Reason:
 * date:  2020-02-06 17:30
 *
 * @author zhongel
 */

public class TestLamda {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1,2,3,4,5);

        //lambda表达式 方法引用
        list.forEach(System.out::println);

        Consumer<Integer> consumer = element->{
            if (element % 2 == 0) {
                System.out.println(element);
            }
        };
        list.forEach(consumer);
        list.removeIf(element->element==7);
    }
}
