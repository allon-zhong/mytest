package com.zel.mytest.tryCatch;

import javax.sound.midi.Soundbank;

/**
 * ClassName:com.zel.mytest.tryCatch.test
 * Function:
 * Reason:
 * date:  2020-01-22 17:33
 *
 * @author zhongel
 */

public class test {

    public static void main(String[] args) {
        try{
                try{
                    System.out.println("1");
                    int i=1/0;
                    System.out.println("2");
                }catch (Exception e){
                    System.out.println("3");
                }finally {
                    System.out.println("4");
                }
        }catch (Exception e){
            System.out.println("5");
        }finally {
            System.out.println("6");
        }
        System.out.println("7");
    }
}
