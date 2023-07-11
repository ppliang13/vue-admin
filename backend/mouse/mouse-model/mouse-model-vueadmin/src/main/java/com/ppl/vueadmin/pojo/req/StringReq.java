package com.ppl.vueadmin.pojo.req;

import lombok.Data;

/**
 * Created by pisiliang on 2023/7/11 14:29
 */
@Data
public class StringReq {
    /**
     * 需要进行转换的字符串
     */
    private String preStr;

    /**
     *处理类型
     */
    private String handleType;


    /**
     * 处理步骤集 id
     */
    private String stepsId;
}
