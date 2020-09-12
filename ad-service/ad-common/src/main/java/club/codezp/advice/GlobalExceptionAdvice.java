package club.codezp.advice;

import club.codezp.exception.AdException;
import club.codezp.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Zpg
 * @Date:2020/8/1 18:51
 * @Version:1.0
 * @Description: 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest request,
                                                     AdException ex){
        CommonResponse<String> response = new CommonResponse<>(-1,"business error");
        return response;
    }


}
