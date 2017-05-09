package mail;

import javax.mail.MessagingException;

public class Client {
	public static void main(String[] args) {
		try {
			MailUtils.sendMail("575871472@qq.com","测试","<p>标题</p><hr/>内容内容内容内容内容内容内容");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
