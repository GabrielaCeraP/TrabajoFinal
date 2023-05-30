package edu.unimagdalena.pw.aerolinia.Excepciones;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExcepcion {

    @ExceptionHandler(UsuarioNoEncontrado.class)
    public  ResponseEntity<ErrorResponse> usuarioNoEncontrado(UsuarioNoEncontrado usuario, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.NOT_FOUND.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    @ExceptionHandler(ReservaDuplicada.class)
    public ResponseEntity<ErrorResponse> reservaDuplicada(ReservaDuplicada duplicado, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.CONFLICT.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }

    @ExceptionHandler(NumAsientosMax.class)
    public ResponseEntity<ErrorResponse> asientosLlenos(NumAsientosMax lleno, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.CONFLICT.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }

    @ExceptionHandler(ReservaNoAprobada.class)
    public ResponseEntity<ErrorResponse> reservaNoEncontrada( ReservaNoAprobada reserva, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.CONFLICT.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }

    @ExceptionHandler(ReservaNoEncontrada.class)
    public ResponseEntity<ErrorResponse> reservaNoEncontrada( ReservaNoEncontrada reserva, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.CONFLICT.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }


}

