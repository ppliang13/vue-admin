package com.ppl.vueadmin.pojo.bo;

import lombok.Data;

/**
 * 处理步骤定义
 * Created by pisiliang on 2023/7/11 14:31
 */
@Data
public class Step {
    /**
     * 步骤名称
     */
    private String stepName;

    /**
     * 步骤类型 --> 确定调用的方法
     */
    private String stepType;

    /**
     * 步骤参数 --> 调用方法的参数
     */
    private String[] stepParam;


}
