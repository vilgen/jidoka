package com.evilemi.jidoka;

import com.evilemi.jidoka.jedis.JedisDao;
import com.evilemi.jidoka.jedis.JedisDaoImpl;
import com.evilemi.jidoka.model.Subscriber;
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
                JedisDao jedisDao;
                @Override
                public void run(String... args) throws Exception {
                        Subscriber subscriber = new Subscriber("1", "5498385519", "Emin", "2023-12-19T00:00:00",
                                "2023-12-19T00:00:00");

                        jedisDao.createSubscriber(subscriber);
                }
        }

}
