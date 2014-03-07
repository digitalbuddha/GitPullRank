package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.model.Pull;
import com.digitalbuddha.rank.model.Repository;
import org.apache.log4j.Logger;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
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


    Logger logger=Logger.getLogger(RestService.class);

    public RestService() {
        //Init a Rest Template with json converter & basic authentication
        restTemplate = new RestClient();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    }

    //Readable Version
    public Repository[] Top5ReposByPullRequest(String orgName) {
        //fetch all repositories
        Repository[] allRepos = new Repository[0];

            final String allReposURL = BASE_URL + "orgs/" + orgName + "/repos";
            allRepos = restTemplate.getForObject(allReposURL, Repository[].class);
            System.out.println(restTemplate.getForObject(allReposURL, String.class));
            //add pull records
            allRepos=addPullData(allRepos);

        //return 5 most popular repos by number of pull requests
        return findTop5Repos(allRepos);
    }

    /*
    //Sexy Version
    public Repository[] Top5ReposByPullRequest(String orgName) {
        //Fetch all Repositories for a given Organzation
        //Add Pull Records to each Repository Record
        //Return the top 5 Repositories by pull records
        return findTop5Repos(addPullData(restTemplate.getForObject(BASE_URL+"orgs/"+orgName+"/repos", Repository[].class)));
    }
    */

    private Repository[] addPullData(Repository[] allRepos) {
        //fetch/set pull data for each Repository

            for(Repository repo:allRepos)
             { //Remove last parameter as we want all pull records not just 1.
               String pullURL=repo.getPulls_url().replace("{/number}","");
               logger.error("Requesting ->"+pullURL);
               Pull[] pulls = restTemplate.getForObject(pullURL, Pull[].class);
               System.out.println(restTemplate.getForObject(pullURL, String.class));

               repo.setPulls(pulls);

             }

        return allRepos;
    }

    private Repository[] findTop5Repos(Repository[] allRepos) {
        //Selection Sort for first 5 elements
        for (int i = 0; i <  allRepos.length-1; i++)
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
}
