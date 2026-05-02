package br.home.vitor.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.home.vitor.exception.RecursoNaoEncontradoException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = RecursoNaoEncontradoException.class)
	public ResponseEntity<Object> handlerNotFound(RecursoNaoEncontradoException ex){
		Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Não Encontrado");
        body.put("message", ex.getMessage());
        body.put("path", "/manager-cep1/consultar"); 
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralError(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Ocorreu um erro interno no servidor.");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
