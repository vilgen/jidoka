package com.evilemi.jidoka.jedis;

import com.evilemi.jidoka.model.Subscriber;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.search.Document;
import redis.clients.jedis.search.FTCreateParams;
import redis.clients.jedis.search.IndexDataType;
import redis.clients.jedis.search.Query;
import redis.clients.jedis.search.schemafields.NumericField;
import redis.clients.jedis.search.schemafields.TagField;
import redis.clients.jedis.search.schemafields.TextField;

@Service
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
        List<Document> documents = jedisClient.ftSearch("idx:subscribers",
                        new Query("@id:{id}"))
                .getDocuments();

        for (Document doc : documents) {
            System.out.println(doc.getId());
            System.out.println(doc.getScore());
            System.out.println(Arrays.toString(doc.getPayload()));
        }
        return null;
    }

    @Override
    public Subscriber querySubscriberByMsisdn(String msisdn) {
        return null;
    }

    @Override
    public void createSubscriber(Subscriber subscriber) {
        jedisClient.jsonSetWithEscape(subscriber.getId(), subscriber);
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

    @Bean
    public void createSubscriberIndex() {

        try {
            if (jedisClient.ftSearch("idx:subscribers").getDocuments().isEmpty()) {
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        jedisClient.ftCreate("idx:subscribers",
                FTCreateParams.createParams().on(IndexDataType.JSON)
                        .addPrefix("subscriber:"),
                TextField.of("$.id").as("id"),
                TextField.of("$.msisdn").as("msisdn"),
                TextField.of("$.name").as("name"),
                TextField.of("$.insertDateTime").as("insertDateTime"),
                TextField.of("$.updateDateTime").as("updateDateTime"));
    }
}
