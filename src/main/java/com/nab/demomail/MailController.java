package com.nab.demomail;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mail")
public class MailController {

  MailObject mailObject =
      new MailObject("nabtestdevelopment@gmail.com", "TITULO..", "CONTENIDO...");

  @Autowired
  public EmailService emailService;

  // Para realizar un POST
  // @Autowired
  // public SimpleMailMessage template;

  @RequestMapping(value = {"/send"}, method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<String> send(@RequestBody MailObject mailObject) {

    if (emailService.sendSimpleMessage(mailObject.getTo(), mailObject.getSubject(),
        mailObject.getText())) {
      return new ResponseEntity<String>("mail enviado correctamente", HttpStatus.OK);
    } else {
      return new ResponseEntity<String>("mail no pudo ser enviado", HttpStatus.CONFLICT);
    }
  }

  @RequestMapping(value = {"/testsend"}, method = RequestMethod.GET)
  public String testsend(Model model, HttpServletRequest request) {

    emailService.sendSimpleMessage(mailObject.getTo(), mailObject.getSubject(),
        mailObject.getText());

    return "mail/send";
  }

}
