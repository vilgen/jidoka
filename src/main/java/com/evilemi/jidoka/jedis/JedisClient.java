package com.evilemi.jidoka.jedis;

import com.evilemi.jidoka.model.Subscriber;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.search.Query;

@Configuration
public class JedisClient {

        private final static String HOST = "localhost";
        private final static int PORT = 6379;

        @Bean(name = "jedis_client")
        public JedisPooled openConnection() {
                return new JedisPooled(HOST, PORT);
        }

}
