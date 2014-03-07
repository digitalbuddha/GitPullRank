package com.digitalbuddha.rank.service;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(null, -1),
                new UsernamePasswordCredentials(username, password));
        HttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}