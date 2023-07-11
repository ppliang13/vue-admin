package com.ppl.vueadmin.pojo.enums;

/**
 * 处理类型
 * Created by pisiliang on 2023/7/11 14:49
 */
public enum HandleTypeEnum {

    /**
     * 一行处理
     */
    ONE_LINE("oneLine", "一行处理"),

    /**
     * 全部处理
     */
    ALL_LINE("allLine", "全部处理");

    private final String code;

    private final String handle;

    HandleTypeEnum(String code, String handle) {
        this.code = code;
        this.handle = handle;
    }

    public String getCode() {
        return code;
    }

    public String getHandle() {
        return handle;
    }

}
