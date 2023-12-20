//package jp.co.jdsnet.base.webapp.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@ControllerAdvice
//public class ExceptionHandleController {
//	
//	@ExceptionHandler(Exception.class)
//    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handle(Exception e) {
//        log.error(e.toString());
//        return "error/5xx";
//    }
//}
