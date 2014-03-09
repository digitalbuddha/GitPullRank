package com.digitalbuddha.rank.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: Nakhimovich
 * Date: 3/7/14
 * Time: 7:33 AM
 * To change this template use File | Settings | File Templates.
 */

public class RestClient extends RestTemplate {
    @Value( "${github.username}")
    private String username="digitalbuddha";
    @Value( "${github.password}")
    private String password="Qwer1234";
    public RestClient() {
        String accessToken = "f8FX29g..."; // access token received from GitHub after OAuth authorization

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization: Bearer", accessToken);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        System.out.println(this.exchange("http://localhost:8080/xxxx", HttpMethod.GET,entity,String.class));
        //http://stackoverflow.com/questionsr/7971119/spring-rest-template-with-oauth;

    }
}