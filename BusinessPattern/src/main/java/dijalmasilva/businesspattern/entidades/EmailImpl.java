/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.entidades;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class EmailImpl {

    private final String hostName = "smtp.gmail.com";
    private final int port = 465;
    private final Email email;
    private final String emailPrincipal = "patterngames1@gmail.com";
    private final String usuario = "Pattern Games";
    private final String senha = "pattern123";

    public EmailImpl() {
        this.email = new SimpleEmail();
        initConfiguration();
    }

    public void sendEmail(String title, String message, String emailAlvo) {
        try {
            email.setSubject(title);
            email.setMsg(message);
            email.addTo(emailAlvo);
            email.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }

    public final void initConfiguration() {
        try {
            email.setHostName(hostName);
            email.setAuthentication(emailPrincipal, senha);
            email.setSSLOnConnect(true);
            email.setFrom(emailPrincipal);
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }
}
