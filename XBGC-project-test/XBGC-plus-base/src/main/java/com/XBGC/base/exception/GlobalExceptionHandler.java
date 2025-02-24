package com.XBGC.base.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 全局异常处理器
 * @author Mr.w
 * @date
 * @version
 */

@Slf4j   //日誌
@ControllerAdvice// 控制器增強
//@RestControllerAdvice = @ResponseBody + @ControllerAdvice
public class GlobalExceptionHandler {


//对项目自定义异常处理
    @ResponseBody  //返回 json格式
    @ExceptionHandler(XBGCPlusException.class)//此方法捕獲XBGCPlusException异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//狀態碼 返回500
    public RestErrorResponse customException(XBGCPlusException e) {

        log.error("【系统异常】{}",e.getErrMessage(),e);
        return new RestErrorResponse(e.getErrMessage());

    }
//针对除了自定yi异常抛出的
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse exception(Exception e) {

        log.error("【系统异常】{}",e.getMessage(),e);
        if (e.getMessage().equals("不允許訪問")) {
            return new RestErrorResponse("\n" +
                    "您没有权限操作此功能");
        }

        return new RestErrorResponse(CommonError.UNKOWN_ERROR.getErrMessage());

    }

    //JSR303 MethodArgumentNotValidException
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse MethodArgumentNotValidException(MethodArgumentNotValidException e) {

        BindingResult bindingResult = e.getBindingResult();
        //存储错误信息
        List<String> errors = new ArrayList<>();
        bindingResult.getFieldErrors().stream().forEach(item ->{
            errors.add(item.getDefaultMessage());
        });
        //将List中错误信息拼接起来
        String errMessage = StringUtils.join(errors,"");
        //记录异常
        log.error("【系统异常】{}",e.getMessage(),e);
        //解析异常
        return new RestErrorResponse(CommonError.UNKOWN_ERROR.getErrMessage());

    }

}

/*
* •	@ExceptionHandler
•	Spring3.0提供的标识在方法上或类上的注解，用来表明方法的处理异常类型。
*
•	@ControllerAdvice
•	Spring3.2提供的新注解，从名字上可以看出大体意思是控制器增强，
*   在项目中来增强SpringMVC中的Controller。通常和@ExceptionHandler 结合使用，来处理SpringMVC的异常信息。
*
•	@ResponseStatus
•	Spring3.0提供的标识在方法上或类上的注解，用状态代码和应返回的原因标记方法或异常类。

* */