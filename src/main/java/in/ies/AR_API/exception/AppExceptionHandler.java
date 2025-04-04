package in.ies.AR_API.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value=SsaWebException.class)
	public ResponseEntity<AppException>handlessaWebException(SsaWebException sx){
		AppException appEx=new AppException();
		appEx.setExCode("EX0001");
		appEx.setExDesc(sx.getMessage());
		appEx.setDate(LocalDateTime.now());
		return new ResponseEntity<AppException>(appEx,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
