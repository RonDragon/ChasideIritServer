package server.main.webServices;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import server.main.beans.Family;
import server.main.beans.Volunteer;
import server.main.enums.DeliveryStatus;
import server.main.enums.FamilyStatus;
import server.main.exception.ServerSystemException;
import server.main.services.AdminImplServices;


@RestController
@RequestMapping("admin")
public class AdminWebService {

	@Autowired
	private AdminImplServices AdminService;

	@RequestMapping(path = "createFamily", method = RequestMethod.POST)
	public Family createFamily(@RequestBody Family family) throws ServerSystemException {
		AdminService.createFamily(family);
		return family;
	}

//	@RequestMapping(path = "removeCompany/{companyId}", method = RequestMethod.DELETE)
//	public boolean removeCompany(@PathVariable int companyId) throws ServerSystemException {		
//		AdminService.removeCompany(companyId);
//		return true;
//	}

	@RequestMapping(path = "updateFamily", method = RequestMethod.PATCH)
	public boolean updateCompany(@RequestBody Family family) throws ServerSystemException {	
		AdminService.updateFamily(family);
		return true;
	}
	
	@RequestMapping(path = "updateFamilyAddress", method = RequestMethod.PATCH)
	public boolean updateFamilyAddress(@RequestBody int familyId, String address) throws ServerSystemException {	
		AdminService.updateFamilyAddress(familyId,address);
		return true;
	}
	
	@RequestMapping(path = "updateFamilyStatus", method = RequestMethod.PATCH)
	public boolean updateFamilyStatus(@RequestBody int familyId, FamilyStatus familyStatus) throws ServerSystemException {	
		AdminService.updateFamilyStatus(familyId,familyStatus);
		return true;
	}
	
	@RequestMapping(path = "setFamilyToVolunteer", method = RequestMethod.PATCH)
	public boolean setFamilyToVolunteer(@RequestBody Volunteer volunteer, Family family) throws ServerSystemException {	
		AdminService.setFamilyToVolunteer(volunteer,family);
		return true;
	}
	
	@RequestMapping(path = "resetDeliveryStatusAndNotes", method = RequestMethod.PATCH)
	public boolean resetDeliveryStatusAndNotes() throws ServerSystemException {	
		AdminService.resetDeliveryStatusAndNotes();
		return true;
	}

	@RequestMapping(path = "getFamilyByID/{familyId}", method = RequestMethod.GET)
	public Optional<Family> getFamilyByID(@PathVariable int familyId) throws ServerSystemException {
		Optional<Family> family = AdminService.getFamilyByID(familyId);
		return family;
	}

	@RequestMapping(path = "getFamilyByName/{familyName}", method = RequestMethod.GET)
	public Family getFamilyByName(@PathVariable String familyName) throws ServerSystemException {
		Family family = AdminService.getFamilyByName(familyName);
		return family;
	}

	@RequestMapping(path = "getFamilyByFamilyStatus/{familyStatus}", method = RequestMethod.GET)
	public List<Family> getFamilyByFamilyStatus(@PathVariable FamilyStatus familyStatus) throws ServerSystemException {
		List<Family> familys = AdminService.getFamilyByFamilyStatus(familyStatus);
		return familys;
	}
	
	@RequestMapping(path = "getFamilyByDeliveryStatus/{deliveryStatus}", method = RequestMethod.GET)
	public List<Family> getFamilyByDeliveryStatus(@PathVariable  DeliveryStatus deliveryStatus) throws ServerSystemException {
		List<Family> familys = AdminService.getFamilyByDeliveryStatus(deliveryStatus);
		return familys;
	}
	
	@RequestMapping(path = "getAllFamilys", method = RequestMethod.GET)
	public List<Family> getAllFamilys() throws ServerSystemException {
		List<Family> familys = AdminService.getAllFamilys();
		return familys;
	}
	
	@RequestMapping(path = "getAllVolunteerOfFamily", method = RequestMethod.GET)
	public List<Volunteer> getAllVolunteerOfFamily(@PathVariable Family family) throws ServerSystemException {
		List<Volunteer> familys = AdminService.getAllVolunteerOfFamily(family);
		return familys;
	}
	


	@RequestMapping(path = "createVolunteer", method = RequestMethod.POST)
	public Volunteer createVolunteer(@RequestBody Volunteer volunteer) throws ServerSystemException {
		AdminService.createVolunteer(volunteer);
		return volunteer;
	}

//	@RequestMapping(path = "removeCustomer", method = RequestMethod.POST)
//	public void removeCustomer(@RequestBody Customer customer) throws ServerSystemException {
//		AdminService.removeCustomer(customer);
//	}

	@RequestMapping(path = "updateVolunteer", method = RequestMethod.POST)
	public Volunteer updateVolunteer(@RequestBody Volunteer volunteer) throws ServerSystemException {
		AdminService.updateVolunteer(volunteer);
		return volunteer;
	}
	
	@RequestMapping(path = "updateVolunteerPhoneNumber", method = RequestMethod.POST)
	public boolean updateVolunteerPhoneNumber(@RequestBody int volunteerId, String volunteerPhoneNumber) throws ServerSystemException {
		AdminService.updateVolunteerPhoneNumber(volunteerId, volunteerPhoneNumber);
		return true;
	}
	
	@RequestMapping(path = "updateVolunteerNumberOfBox", method = RequestMethod.POST)
	public boolean updateVolunteerNumberOfBox(@RequestBody int volunteerId,  int numberOfBox) throws ServerSystemException {
		AdminService.updateVolunteerNumberOfBox(volunteerId, numberOfBox);
		return true;
	}
	
	@RequestMapping(path = "updateVolunteerPartner", method = RequestMethod.POST)
	public boolean updateVolunteerPartner(@RequestBody int volunteerId, Volunteer volunteer) throws ServerSystemException {
		AdminService.updateVolunteerPartner(volunteerId, volunteer);
		return true;
	}

	@RequestMapping(path = "getVolunteerById/{volunteerId}", method = RequestMethod.GET)
	public Optional<Volunteer> getVolunteerById(@RequestBody int volunteerId) throws ServerSystemException {
		Optional<Volunteer> volunteer = AdminService.getVolunteerById(volunteerId);
		return volunteer;
	}

	@RequestMapping(path = "getVolunteerByName", method = RequestMethod.GET)
	public Volunteer getVolunteerByName(@RequestBody String volunteerName) throws ServerSystemException {
		Volunteer customer = AdminService.getVolunteerByName(volunteerName);
		return customer;
	}

	@RequestMapping(path = "getAllVolunteers", method = RequestMethod.GET)
	public List<Volunteer> getAllVolunteers() throws ServerSystemException {
		List<Volunteer>  volunteer = AdminService.getAllVolunteers();
		return volunteer;
	}

	@RequestMapping(path = "getAllFamilyOfVolunteer", method = RequestMethod.GET)
	public List<Family>getAllFamilyOfVolunteer(Volunteer volunteer) throws ServerSystemException {
		List<Family> family = AdminService.getAllFamilyOfVolunteer(volunteer);
		return family;
	}
	

}