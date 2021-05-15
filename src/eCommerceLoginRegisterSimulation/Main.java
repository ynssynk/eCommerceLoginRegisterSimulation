package eCommerceLoginRegisterSimulation;

import eCommerceLoginRegisterSimulation.business.abstracts.UserService;
import eCommerceLoginRegisterSimulation.business.concretes.AuthManager;
import eCommerceLoginRegisterSimulation.business.concretes.MailManager;
import eCommerceLoginRegisterSimulation.business.concretes.UserManager;
import eCommerceLoginRegisterSimulation.core.AuthService;
import eCommerceLoginRegisterSimulation.core.GoogleAuthManagerAdapter;
import eCommerceLoginRegisterSimulation.dataAccess.concretes.HibernateUserDao;
import eCommerceLoginRegisterSimulation.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1=new User(1,"Yunus","Yanýk","yunus@ynk.com","1234656");
		User user2=new User(2,"Yunus","Yanýk","yunus@ynk.com","1234656");
		User user3=new User(3,"Y","Yanýk","yunus@ynkynk.com","1234656");
		User user4=new User(4,"Yunus","Y","yunusynkns.com","1234656");
		UserService userService= new UserManager(new HibernateUserDao(), new MailManager());
		AuthService authService= new AuthManager(userService);
		System.out.println("------Register------");
		authService.register(user1.getFirstName(), user1.getLastName(), user1.getEmail(), user1.getPassword())
		;
		authService.register(user2.getFirstName(), user2.getLastName(), user2.getEmail(), user2.getPassword())
		;
		authService.register(user3.getFirstName(), user3.getLastName(), user3.getEmail(), user3.getPassword())
		;
		authService.register(user4.getFirstName(), user4.getLastName(), user4.getEmail(), user4.getPassword())
		;
		System.out.println("------Login------");
		authService.login(user1.getEmail(), user1.getPassword());
		
		System.out.println("------Google Register------");
		AuthService authService2=new GoogleAuthManagerAdapter();
		authService2.register(user1.getFirstName(), user1.getLastName(), user1.getEmail(), user1.getPassword());
		
		System.out.println("------Google Login------");
		authService2.login(user1.getEmail(), user1.getPassword());
	}

}
