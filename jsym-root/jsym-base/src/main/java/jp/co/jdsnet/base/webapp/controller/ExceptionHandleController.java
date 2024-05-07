package jp.co.jdsnet.base.webapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import jp.fintan.keel.spring.web.token.transaction.InvalidTransactionTokenException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandleController {

  @ExceptionHandler(InvalidTransactionTokenException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public String invalidTransactionTokenExceptionHandler(InvalidTransactionTokenException e) {
    log.error(e.toString());
    return "error/tokenError";
  }
}
