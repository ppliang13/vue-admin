package com.ppl.vueadmin.service;

/**
 * Created by pisiliang on 2023/7/11 14:25
 */
public interface StringService {

    /**
     * 替换字符串
     * @param preStr 原字符串
     * @param oldStr 被替换的字符串
     * @param newStr 替换的字符串
     * @return 替换后的字符串
     */
    String replace(String preStr, String oldStr, String newStr);

    String replaceSize(String preStr, String oldStr, String newStr, int count);

    /**
     * 正则替换
     * @param preStr 原字符串
     * @param regular 正则表达式
     * @param newStr 替换的字符串
     * @return 替换后的字符串
     */
    String replaceRegular(String preStr, String regular, String newStr);

    String replaceRegularSize(String preStr, String regular, String newStr, int count);

    /**
     * 字符串大写
     * @param preStr 原字符串
     * @return 大写字符串
     */
    String toUpperCase(String preStr);

    /**
     * 字符串小写
     * @param preStr 原字符串
     * @return 小写字符串
     */
    String toLowerCase(String preStr);

    /**
     * 字符串转换为英文 替换中文的符号
     * @param preStr 原字符串
     * @return 英文字符串
     */
    String toEnglish(String preStr);


    /**
     * 字符串排序
     * @param preStr 原字符串
     * @return 排序后的字符串
     */
    String lineSort(String preStr);

    /**
     * 字符串排序
     * @param preStr 原字符串
     * @return 排序后的字符串
     */
    String blankSort(String preStr);


    /**
     * 字符串去重 并统计数量
     * @param preStr 原字符串
     * @return 去重后的字符串
     */
    String lineCount(String preStr);
}
