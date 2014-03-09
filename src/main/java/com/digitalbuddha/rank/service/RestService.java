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


    public Repository[] findTop5ReposByPullCount(String orgName) {
      Repository[] allRepos=github.allReposForOrg(orgName);
        allRepos=addPullData(allRepos);
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

    private Repository[] addPullData(Repository[] allRepos) {
        for(Repository repo:allRepos)
        { //Remove last parameter as we want all pull records not just 1.
            String pullURL=repo.getPulls_url().replace("{/number}","");
            logger.debug("Requesting ->" + pullURL);
            Pull[] pulls = github.allPullsForRepo(pullURL);
            repo.setPulls(pulls);
        }
        return allRepos;
    }
}
