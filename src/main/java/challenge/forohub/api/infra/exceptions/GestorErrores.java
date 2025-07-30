package challenge.forohub.api.infra.exceptions;

import challenge.forohub.api.domain.ValidacionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestorErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarError404()
    {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarError400(MethodArgumentNotValidException ex)
    {
        var errores = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(
                errores.stream().map(DatosErrorValidacion::new).toList()
        );
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity tratarErroresValidacion(ValidacionException ex)
    {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    public record  DatosErrorValidacion(String field, String message){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
