package com.evilemi.jidoka.jedis;

import com.evilemi.jidoka.model.Subscriber;
import java.util.List;

public interface JedisDao {

        List<Subscriber> queryAllSubscribers();
        Subscriber querySubscriberById(int id);
        Subscriber querySubscriberByMsisdn(String msisdn);
        void createSubscriber(Subscriber subscriber);
        void createSubscribersBulk(List<Subscriber> subscribers);
        Subscriber updateSubscriber(Subscriber subscriber);
        void deleteSubscriber(int id);
}
