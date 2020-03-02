package com.zel.mytest.leetcode.findLongestWord;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:com.zel.mytest.leetcode.findLongestWord.Solution
 * Function:
 * Reason:
 * date:  2020-01-30 22:48
 *
 * @author zhongel
 */

public class Solution {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        List<String> d = new ArrayList<>();
        d.add("word");
        d.add("good");
        d.add("best");
        d.add("good");
        String longestWord = findLongestWord(s, d);
        System.out.println(longestWord);
    }
    public static String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String tempStr : d) {
            int src = 0;
            int target = 0;

            while (target<s.length() && src<tempStr.length()){
                if(s.charAt(target) == tempStr.charAt(src)){
                    src++;
                }
                target++;
            }
            //遍历完成以后, 如果src 的值为tempStr.length() , 说明能够符合删除字符后匹配目标字符串
            if(src==tempStr.length()){
                if("".equals(result)){
                    result = tempStr;
                }else {
                    if(tempStr.length()>result.length()){
                        result=tempStr;
                    }else if(tempStr.length() == result.length()){

                        int point = 0;
                        while(point<tempStr.length()){
                             if(tempStr.charAt(point) < result.charAt(point)){
                                result = tempStr;
                                break;
                            }else if(tempStr.charAt(point) == result.charAt(point)){
                                 point++;
                                 continue;
                             }else{
                                 break;
                             }

                        }

                    }
                }
            }
        }
        return result;
    }
}
