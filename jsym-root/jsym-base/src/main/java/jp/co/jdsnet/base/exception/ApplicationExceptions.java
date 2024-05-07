package jp.co.jdsnet.base.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ApplicationExceptions extends Exception {

  private static final long serialVersionUID = -2438673694251535883L;

  private Map<String, Exception> exceptions;

  public ApplicationExceptions() {
    exceptions = new HashMap<>();
  }

  public void add(String key, Exception e) {
    exceptions.put(key, e);
  }

  public Map<String, Exception> getExceptions() {
    return exceptions;
  }

  public void setErrorsForBindingResult(BindingResult bindingResult) {
    exceptions.forEach((k, v) -> {
      FieldError fieldError = new FieldError(bindingResult.getObjectName(), k, v.getMessage());
      bindingResult.addError(fieldError);
    });
  }
}
