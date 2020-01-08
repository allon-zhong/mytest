package com.zel.mytest.collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 结论:1.不能在foreach循环中使用remove, 会报异常
 * 2.不能在普通for循环中使用remove, 因为index的值会变, 比如remove(i)之后, 原本处于i+1位置的元素, 会移动到i的位置,
 * 这样的话,下一次循环由于i++了,就会漏掉这个元素. 如下面的代码, remove(3)之后, 后面的元素向前移动, 导致4这个元素没有被遍历到
 * 3.如果要在遍历时移除元素, 请用iterator迭代器
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestList.class}) // 指定启动类
public class TestList {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            System.out.println(s);
            if (s.equals("3") || s.equals("4")) {
                strings.remove(i);
            }
        }
        System.out.println(strings.toString());
    }

    @Test
    public void test() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("0");
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println("遍历元素:"+next);
            if("0".equals(next)){
                iterator.remove();
            }
        }
        System.out.println("遍历后的元素集合:"+strings);
    }


}
