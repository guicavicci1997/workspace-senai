package br.com.senai;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {
	
	public void enviarEmail(String nome, String emailDestinatario) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("guinoreply@gmail.com", "mudar@123"));
            email.setSSLOnConnect(true);

            email.setFrom("guinoreply@gmail.com");
            email.setSubject("Bem vindo ao facebug!");
            email.setMsg("Olá " + nome + ". Você acaba de ingressar no Facebug!");
            email.addTo(emailDestinatario);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
	}
}
