package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.model.Pull;
import com.digitalbuddha.rank.model.Repository;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: Nakhimovich
 * Date: 3/7/14
 * Time: 7:33 AM
 * To change this template use File | Settings | File Templates.
 */
 @Component
public class GitHubClient extends RestTemplate {
    public static final String BASE_URL = "https://api.github.com/";
    private final String accessToken="b94fae3a656f5065e99833c53dbb583a27269859";

    public GitHubClient()
    {
        this.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public Repository[] allReposForOrg(String orgName) {
        final String allReposURL = BASE_URL + "orgs/" + orgName + "/repos?access_token="+accessToken;                                                                                                              ;
        return this.getForObject(allReposURL, Repository[].class);
    }

    public Pull[] allPullsForRepo(String pullURL) {

       return this.getForObject(pullURL+"?access_token="+accessToken, Pull[].class);
    }

    public String getAccessToken() {
        return accessToken;
    }
}