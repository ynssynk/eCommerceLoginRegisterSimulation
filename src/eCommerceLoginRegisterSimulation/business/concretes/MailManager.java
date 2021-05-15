package eCommerceLoginRegisterSimulation.business.concretes;

import eCommerceLoginRegisterSimulation.core.EmailService;

public class MailManager implements EmailService{

	@Override
	public void send(String message) {
		System.out.println(message+" : adresine do�rulama epostas� g�nderildi.");		
	}

	@Override
	public void verify(String message) {
		System.out.println(message+" : mail adresiniz do�ruland�");
		
	}

}
