package server.main.services;

import server.main.beans.*;
import server.main.enums.DeliveryStatus;
import server.main.enums.UserType;
import server.main.exception.ServerSystemException;
import server.main.repositories.FamilyRepository;
import server.main.repositories.VolunteerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerImpServices implements VolunteerServices {

	@Autowired
	private FamilyRepository familyRepository;

	@Autowired
	private VolunteerRepository volunteerRepository;

	

	@Override
	public User login(String volunteerPhoneNumber, UserType type) throws ServerSystemException {
		if (!volunteerPhoneNumber.isEmpty() ) {
			Volunteer VolToGet = volunteerRepository.findByVolunteerPhoneNumber(volunteerPhoneNumber);
			if (VolToGet != null) {
				System.out.println("Login Succes!");
				return new User(VolToGet.getVolunteerId(),VolToGet.getVolunteerName(), UserType.VOLUNTEER);
			}
			else {
				System.err.println("Login Faild!");
			}
		}

		return null;

	}

	@Override
	public List<Family> getMyFamily(int volunteerId) throws ServerSystemException {
		familyRepository.findByVolunteer(volunteerId);
		return null;
	}

	@Override
	public void setDeliveryStatusAndNotes( int familyId,String volunteerNote)
			throws ServerSystemException {
		familyRepository.setDeliveryStatAndNote(familyId,volunteerNote,DeliveryStatus.DONE);
		
	}
}
