package eCommerceLoginRegisterSimulation.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceLoginRegisterSimulation.business.abstracts.UserService;
import eCommerceLoginRegisterSimulation.core.AuthService;
import eCommerceLoginRegisterSimulation.core.EmailService;
import eCommerceLoginRegisterSimulation.entities.concretes.User;


public class AuthManager implements AuthService {

	private UserService userService;
	private EmailService emailService;
	private User user = new User();
	private List<Boolean> rules= new ArrayList<Boolean>();
	public AuthManager(UserService userService, EmailService emailService) {
		super();
		this.userService = userService;
		this.emailService=emailService;
	}
	@Override
	public void login(String email, String password) {		
		user.setEmail(email);
		user.setPassword(password);
		rules.add(checkEmailIsNull(email));
		rules.add(checkPasswordIsNull(password));
		for (Boolean rule : rules) {
			if(rule==false) {
				System.out.println("Giri� i�lemi ba�ar�s�z olmu�tur.");
				return;
			}
		}
		
		System.out.println("Giri� i�lemi ba�ar�l�d�r.");
	}
	@Override
	public void register(String firstName, String lastName, String email, String password) {
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		emailService.send(user.getEmail());
		System.out.println("Email do�ruland�");
		userService.add(user);
		
		
		
	}
	private boolean checkPasswordIsNull(String password) {
		if(password.isEmpty() || password ==null) {
			System.out.println("L�tfen parolan�z� giriniz.");
			return false;
		}
		return true;
	}
	private boolean checkEmailIsNull(String email) {
		if(email.isEmpty() || email ==null) {
			System.out.println("L�tfen emailinizi giriniz.");
			return false;
		}
		return true;
	}

	

}
