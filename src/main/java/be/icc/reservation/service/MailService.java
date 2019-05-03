package be.icc.reservation.service;

import be.icc.reservation.entity.Users;

/**
 * Created by Scohier Dorian on 03-05-19.
 */
public interface MailService {
    void sendConfirmationSignUpEmail(Users user);
}
