package server.main.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import server.main.beans.Volunteer;



@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)	
	@Query(value = "update Volunteer  SET volunteerPhoneNumber = ?2  where volunteerId = ?1", nativeQuery = true)
	void updateVolunteerPhoneNumber(int volunteerId,String volunteerPhoneNumber);

	@Transactional
	@Modifying(clearAutomatically = true)	
	@Query(value = "update Volunteer  SET partner = ?2  where volunteerId = ?1", nativeQuery = true)
	void updateVolunteerPartner(int volunteerId, String volunteerName);

	@Transactional
	@Modifying(clearAutomatically = true)	
	@Query(value = "update Volunteer  SET numberOfBox = ?2  where volunteerId = ?1", nativeQuery = true)
	void updateVolunteerNumberOfBox(int volunteerId, int numberOfBox);

	Volunteer findByVolunteerName(String volunteerName);

	Volunteer findByVolunteerPhoneNumber(String volunteerPhoneNumber);

}


