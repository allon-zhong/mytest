package com.zel.mytest.base;

import java.io.*;
import java.util.HashMap;

public class test {
    /*public static void main(String[] args) throws Exception {
        String zhongerlang = APDes3.encrypt("zhongerlang");
        System.out.println(zhongerlang);
        String decrypt = APDes3.decrypt("WfZ/9sm8M77Je+unMdfJLg==");
        System.out.println(decrypt);
    }*/

    /*public static void main(String[] args) throws IOException {
        String filePath = "D:\\abc\\def\\fed" ;
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath+"\\111.txt"));
        fileOutputStream.write("sldfghsdlf".getBytes());
    }*/

    public static void main(String[] args) {
        String applyNo="R0101010101";
        StringBuffer stringBuffer = new StringBuffer("您好！ 您的理赔申请" + applyNo + "经审核,需补充办理相关手续。 详情请通过我司官微\"补充/补交资料\"推送或联系业务人员查询。 谢谢！");
        System.out.println(stringBuffer);
    }


}
