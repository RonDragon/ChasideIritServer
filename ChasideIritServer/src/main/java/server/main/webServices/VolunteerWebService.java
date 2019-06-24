package server.main.webServices;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import server.main.beans.Family;
import server.main.beans.User;

import server.main.exception.ServerSystemException;

import server.main.services.VolunteerImpServices;

@RestController
@RequestMapping("volunteer")
public class VolunteerWebService {

	@Autowired
	private VolunteerImpServices VolunteerServices;

	public User getLogedUser(HttpServletRequest req) {
		return (User) req.getSession(false).getAttribute("user");	
	}
	
	@RequestMapping(path = "getMyFamily", method = RequestMethod.GET)
	public List<Family> getMyFamily(HttpServletRequest req) throws ServerSystemException {	
		List<Family> familys = VolunteerServices.getMyFamily(getLogedUser(req).getUserId());
		return familys;
	}

	

	@RequestMapping(path = "setDeliveryStatusAndNotes", method = RequestMethod.POST)
	public boolean setDeliveryStatusAndNotes(@RequestBody int familyId,String volunteerNote) throws ServerSystemException {
		VolunteerServices.setDeliveryStatusAndNotes(familyId,volunteerNote);
		return true;
	}

	

}