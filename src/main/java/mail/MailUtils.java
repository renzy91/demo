package mail;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtils {
	private static final String MAIL_USER = "mail_user";
	//密码，此密码为smtp密码
	private static final String MAIL_PASSWORD = "mail_password";
	
	public static void sendMail(String to,String subject,String content) throws AddressException, MessagingException{
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(ConfigUtil.getProperties(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ConfigUtil.getString(MAIL_USER), ConfigUtil.getString(MAIL_PASSWORD));
			}
		}));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setContent(content, "text/html;charset=UTF-8");
		Transport.send(message,message.getAllRecipients());
	}
    
}
