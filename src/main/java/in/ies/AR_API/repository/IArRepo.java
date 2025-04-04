package in.ies.AR_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ies.AR_API.entities.AppEntity;

@Repository
public interface IArRepo extends JpaRepository<AppEntity,Integer> {
	
	@Query("from AppEntity")
	public List<AppEntity> fetchUserApps();
	
	@Query("from AppEntity where user=:userid")
	public List<AppEntity>fetchCwApps(Integer userid);

}
