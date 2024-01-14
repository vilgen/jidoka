package com.evilemi.jidoka.service.impl;

import com.evilemi.jidoka.jedis.JedisDao;
import com.evilemi.jidoka.model.Subscriber;
import com.evilemi.jidoka.service.DaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoServiceImpl implements DaoService {

        @Autowired
        JedisDao jedisDao;
        @Override
        public List<Subscriber> queryAllSubscribers() {
                return jedisDao.queryAllSubscribers();
        }

        @Override
        public Subscriber querySubscriberById(int id) {
                return jedisDao.querySubscriberById(id);
        }

        @Override
        public Subscriber querySubscriberByMsisdn(String msisdn) {
                return jedisDao.querySubscriberByMsisdn(msisdn);
        }

        @Override
        public void createSubscriber(Subscriber subscriber) {
                jedisDao.createSubscriber(subscriber);
        }

        @Override
        public void createSubscribersBulk(List<Subscriber> subscribers) {
                jedisDao.createSubscribersBulk(subscribers);
        }

        @Override
        public Subscriber updateSubscriber(Subscriber subscriber) {
                return jedisDao.updateSubscriber(subscriber);
        }

        @Override
        public void deleteSubscriber(int id) {
                jedisDao.deleteSubscriber(id);
        }
}
