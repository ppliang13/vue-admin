package com.ppl.common.pojo.page;

import lombok.Data;

/**
 * 分页请求 父类接口
 * Created by pisiliang on 2023/6/26 16:04
 */
@Data
public class PageReq {

    private int page = 1;

    private int size = 10;
}
