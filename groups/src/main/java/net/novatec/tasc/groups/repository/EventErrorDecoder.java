package net.novatec.tasc.groups.repository;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class EventErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder errorDecoder = new Default();

  @Override
  public Exception decode(String s, Response response) {
    log.warn("Error when trying to query with feign. {}", s);

    var exception = errorDecoder.decode(s, response);

    if(exception instanceof RetryableException){
      return exception;
    }

    var httpStatus = response.status();

    if (HttpStatus.valueOf(httpStatus).is5xxServerError()) {
      return new RetryableException(httpStatus ,response.reason(), response.request().httpMethod(), exception, null, response.request());
    }
    return exception;
  }
}
