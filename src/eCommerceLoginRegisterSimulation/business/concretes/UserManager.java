package eCommerceLoginRegisterSimulation.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceLoginRegisterSimulation.business.abstracts.UserService;
import eCommerceLoginRegisterSimulation.dataAccess.abstracts.UserDao;
import eCommerceLoginRegisterSimulation.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private List<Boolean> rules= new ArrayList<Boolean>();
	private List<User> users;
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
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
				return;
			}
		}
		this.userDao.add(user);
		this.users.add(user);
		
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
			if(userMail.getEmail().contentEquals(user.getEmail())) {
				System.err.println("Kay�tl� email");
				return false;				
			}
		}
		return true;
	}
	private boolean checkEmailIsRegexFormat(User user) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if(user.getEmail().matches(regex)) {
			return true;
		}
		System.out.println("L�tfen emailinizi do�ru formatta giriniz. :"+user.getEmail());
		return false;
	}
	
	
}
