package server.main.services;

import java.util.List;

import server.main.beans.*;
import server.main.enums.UserType;
import server.main.exception.ServerSystemException;


public interface VolunteerServices {

	User login (String volunteerPhoneNumber, UserType type) throws ServerSystemException ;
	
	List<Family> getMyFamily (int volunteerId) throws ServerSystemException ;
	
	void setDeliveryStatusAndNotes (int familyId,String volunteerNote) throws ServerSystemException ;
	
	


	
}
