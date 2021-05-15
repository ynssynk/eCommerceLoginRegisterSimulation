package eCommerceLoginRegisterSimulation.business.concretes;

import eCommerceLoginRegisterSimulation.core.EmailService;

public class MailManager implements EmailService{

	@Override
	public void send(String message) {
		System.out.println(message+" : adresine doðrulama epostasý gönderildi.");		
	}

	@Override
	public void verify(String message) {
		System.out.println(message+" : mail adresiniz doðrulandý");
		
	}

}
