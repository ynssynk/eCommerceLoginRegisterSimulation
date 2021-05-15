package eCommerceLoginRegisterSimulation.core;

public interface EmailService {
	void send(String message);
	void verify(String message);
}
