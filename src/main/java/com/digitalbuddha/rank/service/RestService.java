package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.model.Pull;
import com.digitalbuddha.rank.model.Repository;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Nakhimovich
 * Date: 3/6/14
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RestService {
    public static final String BASE_URL = "https://api.github.com/";
    public RestTemplate restTemplate;

    public RestService() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    }

    public Repository[] Top5ReposByPullRequest(String orgName) {
        //fetch all repositories
        Repository[] allRepos = new Repository[0];
        try {
            allRepos = restTemplate.getForObject(BASE_URL + "orgs/" + orgName + "/repos", Repository[].class);
            //add pull records
            allRepos=addPullData(allRepos);
        } catch (RestClientException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //return 5 most popular repos by number of pull requests
        return findTop5Repos(allRepos);
    }

    /*
    public Repository[] Top5ReposByPullRequest(String orgName) {
        //Fetch all Repositories for a given Organzation
        //Add Pull Records to each Repository Record
        //Return the top 5 Repositories by pull records
        return findTop5Repos(addPullData(restTemplate.getForObject(BASE_URL + "orgs/" + orgName + "/repos", Repository[].class)));
    }
    */


    private Repository[] addPullData(Repository[] allRepos) {
        //fetch/set pull data for each Repository

        try {
            for(Repository repo:allRepos)
             {
               String pullURL=repo.getPulls_url().replace("{/number}","");
                Pull[] pull = restTemplate.getForObject(pullURL, Pull[].class);
                repo.setPulls(pull);

             }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return allRepos;
    }

    private Repository[] findTop5Repos(Repository[] allRepos) {
        //Selection Sort for first 5 elements
        for (int i = 0; i < 5; i++)
        {
            int index = i;
            for (int j = i + 1; j < allRepos.length; j++)
                if (allRepos[j].getPulls().length > allRepos[index].getPulls().length)
                    index = j;

            Repository mostPulls = allRepos[index];
            allRepos[index] = allRepos[i];
            allRepos[i] = mostPulls;
        }




        return Arrays.copyOf(allRepos,5);
    }

    private Repository[] getAllReposForOrganization(String orgName) {
        // Make the HTTP GET request, marshaling the response from JSON to an array of Repositories
        return restTemplate.getForObject(BASE_URL + "orgs/" + orgName + "/repos", Repository[].class);
    }
}
