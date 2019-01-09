package studying;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSendTest {
  public static void main(String[] args) {
    System.out.println("asdf");
    // naverMailSend();
    gmailSend();
  }

  public static void naverMailSend() {
    String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
    final String user = ""; // 패스워드
    final String password = "";
    // SMTP 서버 정보를 설정한다.

    Properties props = new Properties();
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", 587);
    props.put("mail.smtp.auth", "true");
    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password);
      }
    });
    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(user));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress("")); // 메일
                                                                               // 제목
      message.setSubject("KTKO SMTP TEST1111"); // 메일 내용
      message.setText("KTKO Success!!"); // send the message
      Transport.send(message);
      System.out.println("Success Message Send");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

  public static void gmailSend() {
    String user = ""; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
    String password = ""; // 패스워드

    // SMTP 서버 정보를 설정한다.
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", 465);
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.ssl.enable", "true");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

    Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password);
      }
    });

    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(user));

      // 수신자메일주소
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(""));

      // Subject
      message.setSubject("제목을 입력하세요"); // 메일 제목을 입력

      // Text
      message.setText("내용을 입력하세요"); // 메일 내용을 입력

      // send the message
      Transport.send(message); //// 전송
      System.out.println("message sent successfully...");
    } catch (AddressException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (MessagingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


}
