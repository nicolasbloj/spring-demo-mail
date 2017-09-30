package com.nab.demomail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMailApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoMailApplication.class, args);
  }


  // @Bean
  // public SimpleMailMessage templateSimpleMessage() {
  // SimpleMailMessage message = new SimpleMailMessage();
  // message.setText("This is the test email template for your email:\n%s\n");
  // return message;
  // }

}
