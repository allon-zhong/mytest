package com.zel.mytest.base;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * ClassName:com.zel.mytest.exception.Exceptionutil
 * Function:推荐使用方法3
 * 方法2虽说能够返回“哪里出现了异常”但是它不会报告是你什么异常，而其他三个不但告诉你出现了什么异常，还告诉你那里出现了异常
 * 方法1算是比较好用的，但是从传过来的参数来看，似乎太大了点，咱们平常开发用个Exception就差不多了没必要为了一个简单异常使用Throwable。当然啊，catch中可以catch Excetpion，然后调用Exception.getCause()获取到Throwable对象，但是拿到的Throwable通常都会空的，到Throwable.printStackTrace()时依旧会报错。
 * Reason:
 * date:  2020-03-14 12:57
 *
 * @author zhongel
 */

public class Exceptionutil {

    //1、
    public String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }

    //2、
    public static String getExceptionAllinformation(Exception ex){
        String sOut = "";
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            sOut += "\tat " + s + "\r\n";
        }
        return sOut;
    }

    //3、
    public static String getExceptionAllinformation_01(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
        }
        return ret;
    }

    //4、
    private static String toString_02(Throwable e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}
