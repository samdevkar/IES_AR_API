package in.ies.AR_API.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AppEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long caseNum;

	private String fullname;

	private String email;

	private String gender;

	private LocalDate dob;

	private Long phno;

	private Long ssn;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
