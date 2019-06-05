package com.vedeng.template.common;

import com.vedeng.template.common.exception.VedengErrorCode;
import com.vedeng.template.common.exception.VedengException;

/**
 * @Description: 响应结果
 * @author: Wyatt
 * @Date: 2019-05-30 14:20
 */
public class ResultInfo {

    private String code = "success";

    private Object data = null;

    private String message;

    private boolean success = true;

    public ResultInfo(String code, Object data, String message, boolean success) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public ResultInfo(Object data) {
        this.data = data;
    }

    public static ResultInfo success(Object data) {
        return new ResultInfo(data);
    }

    public static ResultInfo fail(VedengErrorCode errorCode, Object data) {
        return new ResultInfo(errorCode.getCode(), data, errorCode.getMessage(), false);
    }

    public static ResultInfo fail(VedengErrorCode errorCode) {
        return new ResultInfo(errorCode.getCode(), null, errorCode.getMessage(), false);
    }

    public static ResultInfo fail(VedengException exception) {
        return new ResultInfo(exception.getCode(), null, exception.getMessage(), false);
    }

    public static ResultInfo fail(Throwable e) {
        return fail(VedengErrorCode.UNKNOWN_EXCEPTION);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

