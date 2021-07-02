package br.com.lukearch.stoom.restapi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidErrorHandler {

  @Autowired
  private MessageSource ms;
  
  /** 
   * @param exception
   * @return List<FormErrorDto>
   */
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<FormErrorDto> handle(MethodArgumentNotValidException exception) {
    List<FormErrorDto> dto = new ArrayList<>();
    List<FieldError> lErrors =  exception.getBindingResult().getFieldErrors();
    lErrors.forEach(e -> {
      String msg = ms.getMessage(e, LocaleContextHolder.getLocale());
      FormErrorDto error = new FormErrorDto(e.getField(), msg);
      dto.add(error);
    });
    return dto;
  }
}
