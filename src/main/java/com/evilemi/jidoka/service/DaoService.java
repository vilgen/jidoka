package com.evilemi.jidoka.service;

import com.evilemi.jidoka.model.Subscriber;
import java.util.List;

public interface DaoService {

        List<Subscriber> queryAllSubscribers();
        Subscriber querySubscriberById(int id);
        Subscriber querySubscriberByMsisdn(String msisdn);
        void createSubscriber(Subscriber subscriber);
        void createSubscribersBulk(List<Subscriber> subscribers);
        Subscriber updateSubscriber(Subscriber subscriber);
        void deleteSubscriber(int id);
}
