package com.evilemi.jidoka.jedis;

import com.evilemi.jidoka.model.Subscriber;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.search.Query;

@Repository
public class JedisDaoImpl implements JedisDao {

        @Autowired
        @Qualifier("jedis_client")
        private JedisPooled jedisClient;

        @Override
        public List<Subscriber> queryAllSubscribers() {
                var query = new Query("Paul @age:[30 40]");
                var result = jedisClient.ftSearch("idx:users", query).getDocuments();
                System.out.println(result);
                return null;
        }

        @Override
        public Subscriber querySubscriberById(int id) {
                return null;
        }

        @Override
        public Subscriber querySubscriberByMsisdn(String msisdn) {
                return null;
        }

        @Override
        public void createSubscriber(Subscriber subscriber) {

        }

        @Override
        public void createSubscribersBulk(List<Subscriber> subscribers) {

        }

        @Override
        public Subscriber updateSubscriber(Subscriber subscriber) {
                return null;
        }

        @Override
        public void deleteSubscriber(int id) {

        }
}
