package com.evilemi.jidoka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subscriber {

        private int id;
        private String msisdn;
        private String name;
        private String insertDateTime;
        private String updateDateTime;

}
