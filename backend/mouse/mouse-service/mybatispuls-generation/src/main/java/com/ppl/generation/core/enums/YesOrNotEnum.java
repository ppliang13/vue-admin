
package com.ppl.generation.core.enums;

import lombok.Getter;

/**
 * 是或否的枚举
 *
 * @author laifuxing
 * @date 2020/4/13 22:59
 */
@Getter
public enum YesOrNotEnum {

    /**
     * 是
     */
    Y(1,"Y", "是"),

    /**
     * 否
     */
    N(0,"N", "否");


    private  Integer codeNum;

    private  String code;

    private  String message;

    YesOrNotEnum(Integer codenum, String code, String message) {
        this.code = code;
        this.message = message;
        this.codeNum=codenum;
    }

    public static YesOrNotEnum getEnumByCode(String code){
        for (YesOrNotEnum yesOrNotEnum : YesOrNotEnum.values()) {
            if(yesOrNotEnum.getCode().equals(code)){
                return yesOrNotEnum;
            }
        }
        return null;
    }

    public static YesOrNotEnum getEnumByCodeNum(Integer codeNum){
        for (YesOrNotEnum yesOrNotEnum : YesOrNotEnum.values()) {
            if(yesOrNotEnum.getCodeNum().equals(codeNum)){
                return yesOrNotEnum;
            }
        }
        return null;
    }

    public static String getMessageByCode(String code){
        for (YesOrNotEnum yesOrNotEnum : YesOrNotEnum.values()) {
            if(yesOrNotEnum.getCode().equals(code)){
                return yesOrNotEnum.getMessage();
            }
        }
        return null;
    }

    public static String getMessageByCodeNum(Integer codeNum){
        for (YesOrNotEnum yesOrNotEnum : YesOrNotEnum.values()) {
            if(yesOrNotEnum.getCodeNum().equals(codeNum)){
                return yesOrNotEnum.getMessage();
            }
        }
        return null;
    }

    public static Integer getCodeNumByCode(String code){
        for (YesOrNotEnum yesOrNotEnum : YesOrNotEnum.values()) {
            if(yesOrNotEnum.getCode().equals(code)){
                return yesOrNotEnum.getCodeNum();
            }
        }
        return null;
    }

    public static String getCodeByCodeNum(Integer codeNum){
        for (YesOrNotEnum yesOrNotEnum : YesOrNotEnum.values()) {
            if(yesOrNotEnum.getCodeNum().equals(codeNum)){
                return yesOrNotEnum.getCode();
            }
        }
        return null;
    }

    public static String getCodeByMessage(String message){
        for (YesOrNotEnum yesOrNotEnum : YesOrNotEnum.values()) {
            if(yesOrNotEnum.getMessage().equals(message)){
                return yesOrNotEnum.getCode();
            }
        }
        return null;
    }


    public static Integer getCodeNumByMessage(String message){
        for (YesOrNotEnum yesOrNotEnum : YesOrNotEnum.values()) {
            if(yesOrNotEnum.getMessage().equals(message)){
                return yesOrNotEnum.getCodeNum();
            }
        }
        return null;
    }






}
