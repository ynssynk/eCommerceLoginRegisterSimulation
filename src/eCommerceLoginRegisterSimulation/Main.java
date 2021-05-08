package eCommerceLoginRegisterSimulation;

import eCommerceLoginRegisterSimulation.business.abstracts.UserService;
import eCommerceLoginRegisterSimulation.business.concretes.AuthManager;
import eCommerceLoginRegisterSimulation.business.concretes.MailManager;
import eCommerceLoginRegisterSimulation.business.concretes.UserManager;
import eCommerceLoginRegisterSimulation.core.AuthService;
import eCommerceLoginRegisterSimulation.dataAccess.concretes.HibernateUserDao;
import eCommerceLoginRegisterSimulation.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1=new User(1,"Yunus","Yanýk","yunus@ynk.com","1234567");
		UserService userService= new UserManager(new HibernateUserDao());
		AuthService authService= new AuthManager(userService, new MailManager());
		authService.register(user1.getFirstName(), user1.getLastName(), user1.getEmail(), user1.getPassword())
		;
		
	}

}
