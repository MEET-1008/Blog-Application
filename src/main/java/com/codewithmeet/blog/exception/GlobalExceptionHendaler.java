
package com.codewithmeet.blog.exception;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codewithmeet.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHendaler {
	
	@ExceptionHandler(ResouecenotfoundException.class)
	public ResponseEntity<ApiResponse> ResouecenotfoundExceptionHandler (ResouecenotfoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message , false );
		return new ResponseEntity<ApiResponse>(apiResponse ,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Map<String, String >> hendalmethodargnotvalidate(){
		return null;
		
	}
	

}
