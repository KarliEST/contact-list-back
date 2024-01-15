package com.contacts.contactsback.exception;

import com.contacts.contactsback.exception.error.ErrorMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.*;

@RestControllerAdvice
public class ContactExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException e) {
		Map<String, String> errorMap = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(fieldError
				-> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
		return errorMap;
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorMessage> handleInvalidType(MethodArgumentTypeMismatchException e) {
		String inputType = Objects.requireNonNull(e.getValue()).getClass().getSimpleName();
		String requiredType = Objects.requireNonNull(e.getRequiredType()).getSimpleName();
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("invalid id type");
		errorMessage.setDescription("type: " + inputType + ", required type: " + requiredType);
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorMessage>  handleNotFound(EntityNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("contact not found");
		errorMessage.setDescription(e.getMessage());
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
