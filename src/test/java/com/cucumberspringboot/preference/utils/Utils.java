package com.cucumberspringboot.preference.utils;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


@Component
public class Utils {

    public Query withMultipleKeys(String key, String value, String key1, String value1) {
        Criteria criteria = Criteria.where(key).is(value).and(key1).is(value1);
        return Query.query(criteria);
    }

    public Query withSingleKey(String key, String value) {
        Criteria criteria = Criteria.where(key).is(value);
        return Query.query(criteria);
    }

}
