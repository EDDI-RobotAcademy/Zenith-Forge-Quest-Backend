package com.cafe.backend.redis;


public interface RedisService {

    void setUserTokenAndUser (String UUID, String userId);
    String getAccessToken(String userToken);
    void deleteKeyAndValueWithUserToken(String userToken);
}
