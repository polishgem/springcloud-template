package com.vedeng.template.web.exception;

import com.alibaba.fastjson.JSON;
import com.vedeng.template.common.ResultInfo;
import com.vedeng.template.common.exception.VedengErrorCode;
import com.vedeng.template.common.exception.VedengException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Description: 全局异常处理，针对ajax响应
 * @author: Wyatt
 * @Date: 2019-05-30 13:58
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalRestExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultInfo exception(HttpServletRequest reqest, HttpServletResponse response, Exception exception) {
        if (exception instanceof VedengException) {
            return ResultInfo.fail(exception);
        }

        logger.error("global exception", exception);
        return ResultInfo.fail(VedengErrorCode.UNKNOWN_EXCEPTION);
    }




}

