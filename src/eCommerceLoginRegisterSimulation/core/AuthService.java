package eCommerceLoginRegisterSimulation.core;

public interface AuthService {
	void login(String email, String password);
	void register(String firstName, String lastName, String email, String password);
}
