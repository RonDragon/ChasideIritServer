package server.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.main.beans.Family;
import server.main.beans.User;
import server.main.beans.Volunteer;
import server.main.enums.DeliveryStatus;
import server.main.enums.FamilyStatus;
import server.main.enums.UserType;
import server.main.exception.ServerSystemException;
import server.main.repositories.FamilyRepository;
import server.main.repositories.VolunteerRepository;

@Service
public class AdminImplServices implements AdminServices {
	@Autowired
	private FamilyRepository familyRepository;

	@Autowired
	private VolunteerRepository volunteerRepository;

	@Override
	public void createFamily(Family family) throws ServerSystemException {
		familyRepository.save(family);

	}

	@Override
	public void updateFamily(Family family) throws ServerSystemException {
		familyRepository.save(family);
	}

	@Override
	public void updateFamilyAddress(int familyId, String address) throws ServerSystemException {
		familyRepository.updateFamilyAddress(familyId, address);

	}

	@Override
	public void updateFamilyStatus(int familyId, FamilyStatus familyStatus) throws ServerSystemException {
		familyRepository.updateFamilyStatus(familyId, familyStatus);

	}

	@Override
	public void setFamilyToVolunteer(Volunteer volunteer, Family family) throws ServerSystemException {
		familyRepository.setFamilyToVolunteer(volunteer.getVolunteerId(), family.getFamilyId());

	}

	@Override
	public void resetDeliveryStatusAndNotes() throws ServerSystemException {
		List<Family> fam = new ArrayList<Family>();
		fam = familyRepository.findAll();
		for (Family family : fam) {
			family.setVolunteerNote(null);
			family.setDeliveryStatus(DeliveryStatus.WAIT);
		}

	}

	@Override
	public Optional<Family> getFamilyByID(int familyId) throws ServerSystemException {
		return familyRepository.findById(familyId);
	}

	@Override
	public Family getFamilyByName(String familyName) throws ServerSystemException {
		return familyRepository.findByfamilyName(familyName);
	}

	@Override
	public List<Family> getFamilyByFamilyStatus(FamilyStatus familyStatus) throws ServerSystemException {
		return familyRepository.findByFamilyStatus(familyStatus);
	}

	@Override
	public List<Family> getFamilyByDeliveryStatus(DeliveryStatus deliveryStatus) throws ServerSystemException {
		return familyRepository.findByDeliveryStatus(deliveryStatus);
	}

	@Override
	public List<Family> getAllFamilys() throws ServerSystemException {
		return familyRepository.findAll();
	}

	@Override
	public List<Volunteer> getAllVolunteerOfFamily(Family family) throws ServerSystemException {
		// need to check if needed
		return null;
	}

	@SuppressWarnings("static-access")
	@Override
	public User login(String admin, String password, UserType type) throws ServerSystemException {
		if (admin.equals("admin") && password.equals("1234")) {
			return new User(admin, password,type.ADMIN);
		}
		return null;
	}

	@Override
	public void createVolunteer(Volunteer volunteer) throws ServerSystemException {
		volunteerRepository.save(volunteer);

	}

	@Override
	public void updateVolunteer(Volunteer volunteer) throws ServerSystemException {
		volunteerRepository.save(volunteer);

	}

	@Override
	public void updateVolunteerPhoneNumber(int volunteerId, String volunteerPhoneNumber) throws ServerSystemException {
		volunteerRepository.updateVolunteerPhoneNumber(volunteerId, volunteerPhoneNumber);

	}

	@Override
	public void updateVolunteerNumberOfBox(int volunteerId, int numberOfBox) throws ServerSystemException {
		volunteerRepository.updateVolunteerNumberOfBox(volunteerId, numberOfBox);

	}

	@Override
	public void updateVolunteerPartner(int volunteerId, Volunteer volunteer) throws ServerSystemException {
		volunteerRepository.updateVolunteerPartner(volunteerId, volunteer.getVolunteerName());

	}

	@Override
	public Optional<Volunteer> getVolunteerById(int volunteerId) throws ServerSystemException {
		return volunteerRepository.findById(volunteerId);
	}

	@Override
	public Volunteer getVolunteerByName(String volunteerName) throws ServerSystemException {
		return volunteerRepository.findByVolunteerName(volunteerName);
	}

	@Override
	public List<Volunteer> getAllVolunteers() throws ServerSystemException {
		return volunteerRepository.findAll();
	}

	@Override
	public List<Family> getAllFamilyOfVolunteer(Volunteer volunteer) throws ServerSystemException {
		return familyRepository.findAllFamilyOfVolunteer(volunteer.getVolunteerId());
	}

}
