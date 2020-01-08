package com.zel.mytest.sort;

import lombok.Data;

/**
 * ClassName:com.sinosoft.claimappservice.entity
 * Function: 理赔状态轨迹实体类
 * Reason:
 * date: 2019/12/1 18:31
 *
 * @author liangxw
 */
@Data
public class ClaimTraceVo {
    /**操作类型*/
    private String operateType;
    /**操作人代码*/
    private String operatorCode;
    /**操作人姓名*/
    private String operatorName;
    /**最后操作日期*/
    private String lastOperateTime;
    /**最后操作时间*/
    private String makeTime;
}
