package com.zel.mytest.base;

import lombok.Data;

@Data
public class ImgCheckPojo {
    /** 受理号 */
    private String acceptNo ;
    /** 提交日期 */
    private String commitDate ;
    /** 提交时间 */
    private String commitTime ;
    /** 出险人id */
    private String dangerName ;
    /** 机构编号 */
    private String manageCom ;
    /** 受理机构的编号 */
    private String sso ;
    /** 受理人姓名 */
    private String acceptPeople ;
    /** 作废截止时间 */
    private Long endDay ;

}
