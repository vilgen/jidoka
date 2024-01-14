package com.evilemi.jidoka.model;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subscriber {

        private String id;
        private String msisdn;
        private String name;
        private String insertDateTime;
        private String updateDateTime;

        @Override
        public boolean equals(Object o) {
                if (this == o) {
                        return true;
                }
                if (!(o instanceof Subscriber that)) {
                        return false;
                }
                return getId().equals(that.getId()) && Objects.equals(getMsisdn(), that.getMsisdn())
                        && Objects.equals(getName(), that.getName()) && Objects.equals(getInsertDateTime(),
                        that.getInsertDateTime()) && Objects.equals(getUpdateDateTime(), that.getUpdateDateTime());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getId(), getMsisdn(), getName(), getInsertDateTime(), getUpdateDateTime());
        }
}
