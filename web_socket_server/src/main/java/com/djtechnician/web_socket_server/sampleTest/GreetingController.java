package com.djtechnician.web_socket_server.sampleTest;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
  
  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage message) throws Exception {
    System.out.println("GET MESSAGE + " + message.getName());
    Thread.sleep(1000);
    return new Greeting("Hello!, " + message.getName() + "!");
  }

}