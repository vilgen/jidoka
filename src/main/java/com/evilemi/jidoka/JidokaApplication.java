package com.evilemi.jidoka;

import com.evilemi.jidoka.model.Subscriber;
import com.evilemi.jidoka.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JidokaApplication {

        public static void main(String[] args) {
                SpringApplication.run(JidokaApplication.class, args);
        }

        @Component
        public class CommandLineAppStartupRunner implements CommandLineRunner {

                @Autowired
                DaoService jedisDaoService;
                @Override
                public void run(String... args) throws Exception {
                        Subscriber subscriber = new Subscriber("1", "5498385519", "Emin", "2023-12-19T00:00:00",
                                "2023-12-19T00:00:00");
                        Subscriber subscriber2 = new Subscriber("2", "5498385491", "Serkan", "2023-12-19T00:00:00",
                                "2023-12-19T00:00:00");

                        jedisDaoService.createSubscriber(subscriber);
                        jedisDaoService.createSubscriber(subscriber2);

                        jedisDaoService.querySubscriberById(1);
                }
        }

}
