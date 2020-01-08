package com.zel.mytest.collection;

import lombok.Data;

@Data
public class NoteQueryDO {

    //业务来源
    private String  noteSource;  //默认LP
    //批次号
    private String  batchno;
    //照会编号
    private String  noteno;
    //受理号
    private String  acceptno;
    //保单号
    private String  grpContNo;
    //外包商英文名
    private String  tpaEnglishName;
    //照会类型
    private String questiontype;;
    //照会状态
    private String  notestatus;
    //投保单位
    private String  grpname;
    //照会流水号
//    private String  noteCode;
    //出险人姓名
    private String  customername;
    //照会日期       为2的话滞留天数为0
//    private String  notedate;
    //照会创建日期
    private String  notecreatedate;
    //照会创建时间
    private String  notecreatetime;
    /**滞留天数*/
    private String holdDays;


}
