import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendMail {

	public static void main(String[] args) {
		Properties properties = new Properties();
		
		// настройки рассылки
		properties.setProperty("mail.host", "Мой хост");
		properties.setProperty("mail.smtp.port", "Мой порт");
		properties.setProperty("mail.smtp.auth", "true");
		
		Authenticator authenticator = new Authenticator(){
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("username For Server", "Password");
			}
		};
		
		Session session = Session.getDefaultInstance(properties, authenticator);
		
		Message message = new MimeMessage(session);
		
		try {
			message.setSubject("Message subject");
			message.setText("Message Text.........");
			message.setFrom(new InternetAddress("test@yahoo.com", "John"));// от кого
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("bob@gmail.com"));// кому
			
			Transport.send(message);// отправляем
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	}
	
}
