package med.voll.api.infra;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class HandingErrors {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handError400(MethodArgumentNotValidException e) {
        List<FieldError> errors = e.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorsValidation::new).toList());
    }

    private record DataErrorsValidation(String field, String message) {
        public DataErrorsValidation (FieldError err) {
            this(err.getField(), err.getDefaultMessage());
        }
    }

}
