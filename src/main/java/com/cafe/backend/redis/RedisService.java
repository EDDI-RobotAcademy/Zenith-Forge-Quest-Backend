package com.cafe.backend.redis;


public interface RedisService {

    void setKeyAndValue(String token, String accountId);
    Long getValueByKey(String token);
    void deleteByKey(String token);
}
