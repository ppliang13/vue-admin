package com.ppl.api.demo.controller;

import com.ppl.api.demo.pojo.response.ErrorResponseData;
import com.ppl.api.demo.pojo.response.ResponseData;
import com.ppl.api.demo.pojo.response.SuccessResponseData;

/**
 * Created by pisiliang on 2023/6/25 14:35
 */

public class BaseController {


    protected ResponseData success(Object data) {
        return new SuccessResponseData(200, "success", data);
    }

    protected ResponseData error(Integer code,String message) {
        return ErrorResponseData.error(code, message);
    }

    protected ResponseData error(String message) {
        return ErrorResponseData.error(message);
    }
}
