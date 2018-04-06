package com.magn.magnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MagnSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MagnSpringBootApplication.class, args);
    }


    class Message {

        private final String message;

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "message='" + message + '\'' +
                    '}';
        }

    }

    @RestController
    class Resources {

        @RequestMapping(
                method = RequestMethod.GET
        )
        public Message getMessage() {
            return new Message("HOLAAAA");
        }
    }


}
