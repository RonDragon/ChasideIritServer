package server.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.main.beans.User;
import server.main.enums.UserType;
import server.main.exception.ServerSystemException;

@Service
public class LoginService {
	@Autowired
	public AdminImplServices admin;
	
	@Autowired
	public VolunteerImpServices volunteer ;
	

	
	
	
	public  User login(String name , String password , UserType type) {
		switch(type) {
		case ADMIN :
			try {
				return admin.login(name, password, type);
			} catch (ServerSystemException e) {
	
				e.printStackTrace();
			}
		case VOLUNTEER :
			try {
				return volunteer.login(name, type);
			} catch (ServerSystemException e) {
				e.printStackTrace();
			}
		
		default :
			return null;
		}
	}
	
}