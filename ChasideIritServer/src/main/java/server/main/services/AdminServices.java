package server.main.services;

import java.util.List;
import java.util.Optional;

import server.main.beans.Family;
import server.main.beans.User;
import server.main.beans.Volunteer;
import server.main.enums.DeliveryStatus;
import server.main.enums.FamilyStatus;
import server.main.enums.UserType;
import server.main.exception.ServerSystemException;

public interface AdminServices {
	void createFamily (Family family) throws ServerSystemException ;

	void updateFamily (Family family) throws ServerSystemException ;
	
	void updateFamilyAddress (int familyId,String address) throws ServerSystemException ;

	void updateFamilyStatus (int familyId,FamilyStatus familyStatus) throws ServerSystemException ;
	
	void setFamilyToVolunteer (Volunteer volunteer,Family family) throws ServerSystemException ;
	
	void resetDeliveryStatusAndNotes () throws ServerSystemException ;
	
	Optional<Family> getFamilyByID (int familyId) throws ServerSystemException ;

	Family getFamilyByName (String familyName) throws ServerSystemException ;

	List<Family> getFamilyByFamilyStatus (FamilyStatus familyStatus) throws ServerSystemException ;

	List<Family> getFamilyByDeliveryStatus (DeliveryStatus deliveryStatus) throws ServerSystemException ;
	
	List<Family> getAllFamilys () throws ServerSystemException ;

	List<Volunteer> getAllVolunteerOfFamily (Family family) throws ServerSystemException ;
	
	User login (String Admin , String password, UserType type) throws ServerSystemException ;
	
	void createVolunteer (Volunteer volunteer) throws ServerSystemException ;

	void updateVolunteer (Volunteer volunteer) throws ServerSystemException ;
	
	void updateVolunteerPhoneNumber (int volunteerId,String volunteerPhoneNumber) throws ServerSystemException ;
	
	void updateVolunteerNumberOfBox (int volunteerId,int numberOfBox) throws ServerSystemException ;
	
	void updateVolunteerPartner (int volunteerId,Volunteer volunteer) throws ServerSystemException ;

	Optional<Volunteer> getVolunteerById (int volunteerId) throws ServerSystemException ;

	Volunteer getVolunteerByName (String volunteerName) throws ServerSystemException ;
	
	List<Volunteer> getAllVolunteers () throws ServerSystemException ;

	List<Family> getAllFamilyOfVolunteer (Volunteer volunteer) throws ServerSystemException ;

	


}
