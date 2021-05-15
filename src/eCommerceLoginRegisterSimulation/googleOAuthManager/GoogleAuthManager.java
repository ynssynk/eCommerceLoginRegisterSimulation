package eCommerceLoginRegisterSimulation.googleOAuthManager;

public class GoogleAuthManager {
	public void login(String email, String password) {
		if(checkEmailIsNull(email) || checkPasswordIsNull(password)) {
			System.out.println("Giriþ iþleminiz baþarýsýz olmuþtur.");
		}
		System.out.println("Google ile giriþ baþarýlý bir þekilde yapýlmýþtýr. :"+email+" "+password);
	}
	public void register(String firstName, String lastName, String email,String password) {
		System.out.println("Google hesabý ile kayýt oldunuz. "+"Ýsim :"+firstName+" Soyisim : "+lastName+" Email: "+email);
	}
	private boolean checkPasswordIsNull(String password) {
		if(password.isEmpty() || password ==null) {
			System.out.println("Lütfen parolanýzý giriniz.");
			return false;
		}
		return true;
	}
	private boolean checkEmailIsNull(String email) {
		if(email.isEmpty() || email ==null) {
			System.out.println("Lütfen emailinizi giriniz.");
			return false;
		}
		return true;
	}
}
