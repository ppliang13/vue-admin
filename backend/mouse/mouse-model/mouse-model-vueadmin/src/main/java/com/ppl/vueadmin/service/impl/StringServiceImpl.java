package com.ppl.vueadmin.service.impl;


import com.ppl.vueadmin.service.StringService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pisiliang on 2023/7/11 14:24
 */
@Service
public class StringServiceImpl implements StringService {

    @Override
    public String replace(String preStr, String oldStr, String newStr) {
        return preStr.replaceAll(oldStr, newStr);
    }

    @Override
    public String replaceSize(String preStr, String oldStr, String newStr, int count) {
        for (int i = 0; i < count; i++) {
            preStr = preStr.replaceFirst(oldStr, newStr);
            if(!preStr.contains(oldStr)){
                break;
            }
        }
        return preStr;
    }

    @Override
    public String replaceRegular(String preStr, String regular, String newStr) {
        return preStr.replaceAll(regular, newStr);
    }

    @Override
    public String replaceRegularSize(String preStr, String regular, String newStr, int count) {
        // 使用正则表达式将满足条件的前 count 个实例替换为 newStr
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(preStr);
        StringBuffer replacedText = new StringBuffer();
        int replaceCount = 0;

        while (matcher.find() && replaceCount < count) {
            matcher.appendReplacement(replacedText, Matcher.quoteReplacement(newStr));
            replaceCount++;
        }
        matcher.appendTail(replacedText);

        return replacedText.toString();
    }

    @Override
    public String toUpperCase(String preStr) {
        return preStr.toUpperCase();
    }

    @Override
    public String toLowerCase(String preStr) {
        return preStr.toLowerCase();
    }

    @Override
    public String toEnglish(String preStr) {
        char[] chars = preStr.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if (c == '（') {
                builder.append("(");
            } else if (c == '）') {
                builder.append(")");
            } else if (c == '【') {
                builder.append("[");
            } else if (c == '】') {
                builder.append("]");
            } else if (c == '｛') {
                builder.append("{");
            } else if (c == '｝') {
                builder.append("}");
            } else if (c == '《') {
                builder.append("<");
            } else if (c == '》') {
                builder.append(">");
            } else if (c == '，' || c == '、') {
                builder.append(",");
            } else if (c == '。') {
                builder.append(".");
            } else if (c == '；') {
                builder.append(";");
            } else if (c == '：') {
                builder.append(":");
            } else if (c == '‘' || c == '’') {
                builder.append("'");
            } else if (c == '“' || c == '”') {
                builder.append("\"");
            } else if (c == '？') {
                builder.append("?");
            } else if (c == '！') {
                builder.append("!");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    @Override
    public String lineSort(String preStr) {
        // 将字符串按行分割为数组
        String[] lines = preStr.split("\\r?\\n");
        // 对数组进行排序
        Arrays.sort(lines);
        // 将排序后的数组合并为字符串
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public String blankSort(String preStr) {
        // 将字符串按空格分割为数组
        String[] blanks = preStr.split("\\s+");
        // 对数组进行排序
        Arrays.sort(blanks);
        // 将排序后的数组合并为字符串
        StringBuilder builder = new StringBuilder();
        for (String blank : blanks) {
            builder.append(blank).append(" ");
        }
        return builder.toString();
    }

    @Override
    public String lineCount(String preStr) {
        String[] lines = preStr.split("\\r?\\n");
        HashMap<String, Integer> map = new HashMap<>();
        for (String line : lines) {
            Integer integer = map.get(line);
            if(integer == null||integer == 0){
                map.put(line, 1);
            }else {
                map.put(line, integer+1);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String key : map.keySet()) {
            builder.append(map.get(key)).append("\t").append("[").append(key).append("]").append(System.lineSeparator());
        }
        return builder.toString();
    }
}
