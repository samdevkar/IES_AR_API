package in.ies.AR_API.bindings;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class App {
	private Long caseNum;

	private String fullname;

	private String email;

	private String phno;

	private String gender;

	private LocalDate dob;

	private Long ssn;
	
	private Integer userId;

}
