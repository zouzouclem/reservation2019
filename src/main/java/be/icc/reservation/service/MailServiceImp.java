package be.icc.reservation.service;
import be.icc.reservation.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("javasampleapproachMailSender")
public class MailServiceImp implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendConfirmationSignUpEmail(Users user) {
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom("app2019icc@gmail.com");
        mail.setTo(user.getEmail());
        mail.setSubject("Confirmation de l'inscription");
        mail.setText("Bienvenue sur app " + user.getLogin());

        logger.info("Sending...");

        javaMailSender.send(mail);

        logger.info("Done!");
    }
}

