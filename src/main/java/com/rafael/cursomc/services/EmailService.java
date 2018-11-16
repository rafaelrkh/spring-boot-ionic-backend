package com.rafael.cursomc.services;

import com.rafael.cursomc.domain.Pedidos;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedidos obj);
	
	void sendEmail(SimpleMailMessage msg);
}
