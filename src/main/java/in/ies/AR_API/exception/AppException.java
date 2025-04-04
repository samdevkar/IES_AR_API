package in.ies.AR_API.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException {

	private String exCode;

	private String exDesc;

	private LocalDateTime date;

}
