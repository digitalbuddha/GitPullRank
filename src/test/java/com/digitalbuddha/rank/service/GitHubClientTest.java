package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.model.Repository;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class GitHubClientTest extends BaseTestCase {


    @Test
    public void testAllReposForOrgMock() throws Exception {
        createReposResponse(NETFLIX);
        final Repository[] repositories = github.allReposForOrg(NETFLIX);
        assertNotNull(repositories);
    }

    @Test
    public void testPullsForRepoMock() throws Exception {
        String pullURL = "https://api.github.com/repos/Netflix/asgard/pulls";
        createPullResponse(pullURL);
        assertNotNull(github.allPullsForRepo(pullURL));
    }


//    @Test
//    public void testAllReposForOrg() throws Exception {
//        final String NETFLIX = "netflix";
//        final String allReposURL = BASE_URL + "orgs/" + NETFLIX + "/repos?access_token="+github.getAccessToken();                                                                                                              ;
//
//        assertNotNull(github.allReposForOrg(NETFLIX));
//    }
//
//    @Test
//    public void testPullsForRepo() throws Exception {
//         assertNotNull(github.allPullsForRepo("https://api.github.com/repos/Netflix/asgard/pulls"));
//    }


}
