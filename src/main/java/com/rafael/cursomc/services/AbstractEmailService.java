package com.rafael.cursomc.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.rafael.cursomc.domain.Pedidos;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendOrderConfirmationEmail(Pedidos obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedidos obj) {
		SimpleMailMessage sm = new SimpleMailMessage();

		sm.setTo(obj.getCliente().getDs_email());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getCd_pedido());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());

		return sm;
	}

	protected String htmlFromTemplatePedido(Pedidos obj) {

		Context context = new Context(); // Objeto que acessa o template
		context.setVariable("pedido", obj);
		
		return templateEngine.process("email/confirmacaoPedido", context);		
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Pedidos obj) {
		
		try {
			
		MimeMessage mm = prepareMimeMessageFromPedido(obj);
		sendHtmlEmail(mm);
		
		} catch(MessagingException e) {//Se não der com HTML vai com modo texto
			sendOrderConfirmationEmail(obj);
		}
		
	}

	protected MimeMessage prepareMimeMessageFromPedido(Pedidos obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage,true);
		
		mmh.setTo(obj.getCliente().getDs_email());
		mmh.setFrom(sender);
		mmh.setSubject("Pedido confirmado! Código: " + obj.getCd_pedido());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj), true);	

		return mimeMessage;
	}
}
