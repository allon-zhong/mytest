package com.zel.mytest.sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class SortTest {
    public static void main(String[] args) {
        ArrayList<ClaimTraceVo> claimTraceVos = new ArrayList<>();
        ClaimTraceVo claimTraceVo1 = new ClaimTraceVo();
        claimTraceVo1.setOperateType("1");
        claimTraceVo1.setLastOperateTime("2014-01-01");
        claimTraceVo1.setMakeTime("13:01:01");
        claimTraceVos.add(claimTraceVo1);
        ClaimTraceVo claimTraceVo2 = new ClaimTraceVo();
        claimTraceVo2.setOperateType("2");
        claimTraceVo2.setLastOperateTime("2014-01-01");
        claimTraceVo2.setMakeTime("19:01:01");
        claimTraceVos.add(claimTraceVo2);
        ClaimTraceVo claimTraceVo3 = new ClaimTraceVo();
        claimTraceVo3.setOperateType("3");
        claimTraceVo3.setLastOperateTime("2014-01-01");
        claimTraceVo3.setMakeTime("18:01:01");
        claimTraceVos.add(claimTraceVo3);
        ClaimTraceVo claimTraceVo4 = new ClaimTraceVo();
        claimTraceVo4.setOperateType("4");
        claimTraceVo4.setLastOperateTime("2014-01-01");
        claimTraceVo4.setMakeTime("16:01:01");
        claimTraceVos.add(claimTraceVo4);
        ClaimTraceVo claimTraceVo5 = new ClaimTraceVo();
        claimTraceVo5.setOperateType("5");
        claimTraceVo5.setLastOperateTime("2014-01-01");
        claimTraceVo5.setMakeTime("17:01:01");
        claimTraceVos.add(claimTraceVo5);

        claimTraceVos.sort(new Comparator<ClaimTraceVo>() {
            @Override
            public int compare(ClaimTraceVo o1, ClaimTraceVo o2) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStrA = o1.getLastOperateTime() + " " + o1.getMakeTime();
                String dateStrB = o2.getLastOperateTime() + " " + o2.getMakeTime();
                try {
                    Date dateA = simpleDateFormat.parse(dateStrA);
                    Date dateB = simpleDateFormat.parse(dateStrB);
                    if (dateA.before(dateB)){
                        return 1;
                    }else if(dateA.after(dateB)){
                        return -1;
                    }else{
                        return 0;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        System.out.println(claimTraceVos.toString());
    }
}
