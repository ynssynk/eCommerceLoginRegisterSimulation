package eCommerceLoginRegisterSimulation.business.abstracts;

import java.util.List;

import eCommerceLoginRegisterSimulation.entities.concretes.User;

public interface UserService {
	void add(User user);
	List<User> getAll();
}
