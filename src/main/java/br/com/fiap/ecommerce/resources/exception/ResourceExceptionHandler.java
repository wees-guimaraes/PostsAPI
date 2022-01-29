package br.com.fiap.ecommerce.resources.exception;

import br.com.fiap.ecommerce.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError =
                new StandardError(System.currentTimeMillis(),
                        httpStatus.value(),
                        "Not Found",
                        e.getMessage(),
                        request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
