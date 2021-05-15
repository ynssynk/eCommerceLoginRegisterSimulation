package eCommerceLoginRegisterSimulation.googleOAuthManager;

public class GoogleAuthManager {
	public void login(String email, String password) {
		if(checkEmailIsNull(email) || checkPasswordIsNull(password)) {
			System.out.println("Giri� i�leminiz ba�ar�s�z olmu�tur.");
		}
		System.out.println("Google ile giri� ba�ar�l� bir �ekilde yap�lm��t�r. :"+email+" "+password);
	}
	public void register(String firstName, String lastName, String email,String password) {
		System.out.println("Google hesab� ile kay�t oldunuz. "+"�sim :"+firstName+" Soyisim : "+lastName+" Email: "+email);
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
