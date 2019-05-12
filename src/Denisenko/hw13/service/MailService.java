package denisenko.hw13.service;

import denisenko.hw13.dao.CodeDao;
import denisenko.hw13.utils.RandomHelper;
import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {

    private static final Logger LOGGER = Logger.getLogger(MailService.class);
    public static final CodeDao codeDao = new CodeDao();

    public String sendMailWithCode(String userEmail) {

        final String username = "meha334@gmail.com";
        final String password = "aE3102ha";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("meha334@gmail.com"));
            message.setRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(userEmail)
            );
            message.setSubject("Одноразовый код подтверждения покупки");
            String generateCode = RandomHelper.getRandomStrFrom4Digit();
            LOGGER.debug("Generate random code " + generateCode);
            message.setText("Ваш код " + generateCode);

            Transport.send(message);
            LOGGER.debug("Done");
            return generateCode;
        } catch (MessagingException e) {
            LOGGER.error("Cant send emai", e);
            return "";
        }

    }
}
