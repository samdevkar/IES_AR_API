package in.ies.AR_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.ies.AR_API.entities.UserEntity;

public interface IUserRepo extends JpaRepository<UserEntity,Integer> {

	@Query("update UserEntity set accStatus=:status where userId=:id")
	public Integer updateAccountStatus(@Param("id") Integer id, String status);

	@Query("from UserEntity where email=:email")
	public UserEntity findByEmail(String email);

	public UserEntity findByEmailAndPwd(String email, String pwd);
	
}