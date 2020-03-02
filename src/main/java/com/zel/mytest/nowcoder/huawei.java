package com.zel.mytest.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName:com.zel.mytest.nowcoder.huawei
 * Function:
 * Reason:
 * date:  2020-02-19 11:29
 *
 * @author zhongel
 */

public class huawei {
    public static void main( String[] args){
        Scanner sc = new Scanner( System.in);
        while( sc.hasNext()){
            int time = sc.nextInt();
            String[] con = new String[time];
            for ( int i = 0; i < time ; i++){
                con[i] = sc.next();
            }
            Arrays.sort(con);
            String res = "";
            for ( int i = 0; i < con.length; i++){
                if( i == con.length - 1){
                    res += con[i];
                }else{
                    res += con[i] + " ";
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}
