package com.zel.mytest.nowcoder;

/**
 * ClassName:com.zel.mytest.nowcoder.Main
 * Function:
 * Reason:
 * date:  2020-02-20 14:17
 *
 * @author zhongel
 */

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] ints = new int[num];
        int i = 0 ;
        while(sc.hasNextInt() && i <num){
            ints[i++] = sc.nextInt();
        }
        int temp = 1; //差值max
        int index = 0;//跳跃的目标位置
        int result = 0 ; //返回的跳跃次数
        for(int j = 0;j+ints[j]<ints.length;){
            int i1 = 0;
            for(int k = j+1;k<=j+ints[j];k++){
                if(i1==0){
                    i1 = ints[k] - k;
                    temp = i1;
                    index = k ;
                }else if(ints[k]-k>i1){
                    i1 = ints[k]-k;
                    temp = i1;
                    index = k ;
                }
            }
            result ++;
            j = index;
        }
        System.out.println(result);
    }
}
