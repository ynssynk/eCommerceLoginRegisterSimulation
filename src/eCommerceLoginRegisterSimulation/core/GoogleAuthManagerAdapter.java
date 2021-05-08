package eCommerceLoginRegisterSimulation.core;

import eCommerceLoginRegisterSimulation.googleOAuthManager.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService{

	@Override
	public void login(String email, String password) {
		GoogleAuthManager googleAuthManager= new GoogleAuthManager();
		googleAuthManager.login(email, password);
	}
	@Override
	public void register(String firstName, String lastName, String email, String password) {
		GoogleAuthManager googleAuthManager= new GoogleAuthManager();
		googleAuthManager.register(firstName, lastName, email, password);
		
	}

}
