package com.digitalbuddha.rank.service;
import com.digitalbuddha.rank.model.Repository;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class RestServiceTest extends BaseTestCase {

    @Test
    public void testFindTop5ReposByPullCountMock() throws Exception {
        createReposResponse(NETFLIX);
        createMockPullResponses();
        Repository[] topRepos = restService.findTop5ReposByPullCount(NETFLIX, 5, false);

        for(int i=1;i<topRepos.length;i++)
        {
        assertTrue("Top Repositories are not in sorted order",topRepos[i-1].getPullCount()>=topRepos[i].getPullCount());
        }
    }

    @Test
    public void testFindTop5ReposByPullCountExpandedMock() throws Exception {
        createReposResponse(NETFLIX);
        createMockPullResponses();
        Repository[] topRepos = restService.findTop5ReposByPullCount(NETFLIX, 5, true);

        for(int i=1;i<topRepos.length;i++)
        {
            assertTrue("Top Repositories are not in sorted order",topRepos[i-1].getPullCount()>=topRepos[i].getPullCount());

        }
    }



//    @Test
//    public void testFindTop5ReposByPullCount() throws Exception {
//        Repository[] topRepos = restService.findTop5ReposByPullCount(NETFLIX, false);
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        System.out.println("Result->:" + ow.writeValueAsString(topRepos));
//    }
    private void createMockPullResponses() {
        createPullResponse("https://api.github.com/repos/Netflix/astyanax/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/curator/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/Priam/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/CassJMeter/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/servo/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/aws-autoscaling/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/exhibitor/pulls{/number}");
    }

}
