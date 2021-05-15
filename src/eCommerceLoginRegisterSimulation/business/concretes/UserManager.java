package eCommerceLoginRegisterSimulation.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceLoginRegisterSimulation.business.abstracts.UserService;
import eCommerceLoginRegisterSimulation.core.EmailService;
import eCommerceLoginRegisterSimulation.dataAccess.abstracts.UserDao;
import eCommerceLoginRegisterSimulation.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private EmailService emailService;
	private List<Boolean> rules= new ArrayList<Boolean>();
	private List<User> users;
	public UserManager(UserDao userDao,EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService=emailService;
	}

	@Override
	public void add(User user) {
		rules.add(checkPasswordLength(user));
		rules.add(checkFirstNameLength(user));
		rules.add(checkLastNameLength(user));
		rules.add(checkEmailExists(user));
		rules.add(checkEmailIsRegexFormat(user));
		for (Boolean rule : rules) {
			if(rule==false) {
				System.out.println("Validasyon kurallar�ndan ge�emedi");
				return;
			}
		}
		this.userDao.add(user);
		this.users.add(user);
		this.emailService.send(user.getEmail());
		this.emailService.verify(user.getEmail()+ " Kayd�n�z ba�ar�yla tamamlanm�t�r.");
		
				
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	private boolean checkPasswordLength(User user) {
		if(user.getPassword().length()<7) {
			System.out.println("�ifreniz en az 6 karakterden olu�mal�d�r.");
			return false;
		}		
		return true;
	}
	private boolean checkFirstNameLength(User user) {
		if(user.getFirstName().length()<2) {
			System.out.println("�sim minimum 2 karekter uzunlu�unda olmal�d�r.");
			return false;
		}
		return true;
	}
	private boolean checkLastNameLength(User user) {
		if(user.getLastName().length()<2) {
			System.out.println("Soy isim minimum 2 karekter uzunlu�unda olmal�d�r.");
			return false;
		}
		return true;
	}
	private boolean checkEmailExists(User user) {
		users=userDao.getAll();
		for(User userMail:users) {
			if(userMail.getEmail().equals(user.getEmail())) {
				System.err.println("Kay�tl� email");
				return false;				
			}
		}
		return true;
	}
	private boolean checkEmailIsRegexFormat(User user) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(user.getEmail());
		if(matcher.matches()==false) {
			System.err.println("Email format� dogru de�il. :"+user.getEmail());
			return false;
		}	
		return true;
	}
	
	
}
