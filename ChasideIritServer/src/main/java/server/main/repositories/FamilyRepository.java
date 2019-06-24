package server.main.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import server.main.beans.Family;
import server.main.enums.DeliveryStatus;
import server.main.enums.FamilyStatus;



@Repository // Our DAO component
public interface FamilyRepository extends JpaRepository<Family, Integer>  {

	@Transactional
	@Modifying(clearAutomatically = true)	
	@Query(value = "update Family  SET address = ?2  where familyId = ?1", nativeQuery = true)
	void updateFamilyAddress(int familyId, String address);

	@Transactional
	@Modifying(clearAutomatically = true)	
	@Query(value = "update Family  SET familyStatus = ?2  where familyId = ?1", nativeQuery = true)
	void updateFamilyStatus(int familyId, FamilyStatus familyStatus);

	void setFamilyToVolunteer(int volunteerId, int familyId);

	Family findByfamilyName(String familyName);

	List<Family> findByFamilyStatus(FamilyStatus familyStatus);

	List<Family> findByDeliveryStatus(DeliveryStatus deliveryStatus);

	List<Family> findAllFamilyOfVolunteer(int volunteerId);

	void findByVolunteer(int volunteerId);

	@Transactional
	@Modifying(clearAutomatically = true)	
	@Query(value = "update Family  SET volunteerNote = ?2, DeliveryStatus = ?3  where familyId = ?1", nativeQuery = true)
	void setDeliveryStatAndNote(int familyId, String volunteerNote, DeliveryStatus done);
	
}

