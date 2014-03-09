package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.model.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Nakhimovich
 * Date: 3/9/14
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestServiceTest extends BaseTestCase {
    @Test
    public void testFindTop5ReposByPullCount() throws Exception {
        createReposResponse(NETFLIX);
        createPullResponse("https://api.github.com/repos/Netflix/astyanax/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/curator/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/Priam/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/CassJMeter/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/servo/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/aws-autoscaling/pulls{/number}");
        createPullResponse("https://api.github.com/repos/Netflix/exhibitor/pulls{/number}");
        Repository[] topRepos= restService.findTop5ReposByPullCount(NETFLIX);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        System.out.println("Result->:"+ow.writeValueAsString(topRepos));
    }
}
