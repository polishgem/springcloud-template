package com.vedeng.template.common.exception;

public enum VedengErrorCode {

    //全局异常定义，各模块命名规范：模块_二级模块_错误信息
    UNKNOWN_EXCEPTION("unknown_exception","系统内部错误"),
    PARAM_NULL("param_null", "参数不能为空"),


    //登录
    LOGIN_NAME_NULL("login_name_null", "登录用户名不能为空")
    ;


    private String code;
    private String message;


    private VedengErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
