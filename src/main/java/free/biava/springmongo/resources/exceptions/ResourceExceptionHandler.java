package free.biava.springmongo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import free.biava.springmongo.services.exceptions.DatabaseException;
import free.biava.springmongo.services.exceptions.ResourceNotFoundExcepetion;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundExcepetion.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundExcepetion RnFoundException, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status.value(), RnFoundException.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseError(DatabaseException dbException, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(Instant.now(), status.value(), dbException.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

}
