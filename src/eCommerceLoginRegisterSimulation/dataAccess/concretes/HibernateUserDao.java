package eCommerceLoginRegisterSimulation.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceLoginRegisterSimulation.dataAccess.abstracts.UserDao;
import eCommerceLoginRegisterSimulation.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users=new ArrayList<>();
	@Override
	public void add(User user) {
		System.out.println("Hibernate ile kayýt edildi: "+user.getFirstName()+" "+user.getLastName());
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile kayýt güncellendi: "+user.getFirstName()+" "+user.getLastName());
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile kayýt silindi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
