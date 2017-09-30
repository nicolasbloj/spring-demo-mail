package com.nab.demomail;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mail")
public class MailController {

  MailObject mailObject = new MailObject("zzzzzzzzzzzzzzzzzzzzzzz", "TITULO..", "CONTENIDO...");

  @Autowired
  public EmailService emailService;

  // Para realizar un POST
  // @Autowired
  // public SimpleMailMessage template;

  @RequestMapping(value = {"/send"}, method = RequestMethod.GET)
  public String createMail(Model model, HttpServletRequest request) {

    emailService.sendSimpleMessage(mailObject.getTo(), mailObject.getSubject(),
        mailObject.getText());

    return "mail/send";
  }

}
