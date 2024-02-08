package med.voll.api.infra;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandingErrors {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handError404() {
        return ResponseEntity.notFound().build();
    }

}
