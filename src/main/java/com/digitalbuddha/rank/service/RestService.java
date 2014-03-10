package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.model.Pull;
import com.digitalbuddha.rank.model.Repository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class RestService {
    @Autowired
    public GitHubClient github;
    Logger logger=Logger.getLogger(RestService.class);


    public Repository[] findTop5ReposByPullCount(String orgName, int numberToReturn, Boolean expanded) {
        logger.debug("Requesting All Repos for->" + orgName);
        Repository[] allRepos=github.allReposForOrg(orgName);
        allRepos=addPullData(allRepos,expanded);
        for (int i = 0; i <  allRepos.length-1; i++)
        {
            int index = i;
            for (int j = i + 1; j < allRepos.length; j++)
                if (allRepos[j].getPullCount() > allRepos[index].getPullCount())
                    index = j;
            Repository mostPulls = allRepos[index];
            allRepos[index] = allRepos[i];
            allRepos[i] = mostPulls;
        }
        return Arrays.copyOf(allRepos,numberToReturn);
    }

    private Repository[] addPullData(Repository[] allRepos,  Boolean expanded) {
        for(Repository repo:allRepos)
        { //Remove last parameter as we want all pull records not just 1.
            String pullURL=repo.getPulls_url().replace("{/number}","");
            logger.debug("Requesting ->" + pullURL);
            Pull[] pulls = github.allPullsForRepo(pullURL);
            repo.setPullCount(pulls.length);
            if (expanded)
            {
                repo.setPulls(pulls);
            }
        }
        return allRepos;
    }
}
