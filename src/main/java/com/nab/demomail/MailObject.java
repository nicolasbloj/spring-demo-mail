package com.nab.demomail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Created by Olga on 7/20/2016.
 */
public class MailObject {
  @Email
  @NotNull
  @Size(min = 1, message = "Please, set an email address to send the message to it")
  private String to;
  private String subject;
  private String text;



  public MailObject(String to, String subject, String text) {
    super();
    this.to = to;
    this.subject = subject;
    this.text = text;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
