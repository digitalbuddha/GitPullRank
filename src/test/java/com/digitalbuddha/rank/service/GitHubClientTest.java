package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.Application;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class,loader=AnnotationConfigContextLoader.class)
public class GitHubClientTest {
    public static final String BASE_URL = "https://api.github.com/";

    @Autowired
    GitHubClient github;
    private String orgName;
    private MockRestServiceServer mockServer;


    @BeforeClass
    public void setup()
    {
        mockServer = MockRestServiceServer.createServer(github);
    }
    @Test
    public void testAllReposForOrgMock() throws Exception {
        orgName = "netflix";
        final String allReposURL = BASE_URL + "orgs/" + orgName + "/repos?access_token="+github.getAccessToken();                                                                                                              ;


        mockServer.expect(requestTo(allReposURL))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("AllReposOrg"), MediaType.APPLICATION_JSON)
                );
        assertNotNull(github.allReposForOrg(orgName));
    }

    @Test
    public void testPullsForRepoMock() throws Exception {
            final String pullURL = "https://api.github.com/repos/Netflix/asgard/pulls";

            mockServer.expect(requestTo(pullURL))
                    .andExpect(method(GET))
                    .andRespond(withSuccess(jsonResource("Pulls"), MediaType.APPLICATION_JSON)
                    );
            assertNotNull(github.allPullsForRepo(pullURL));
    }


//    @Test
//    public void testAllReposForOrg() throws Exception {
//        final String orgName = "netflix";
//        final String allReposURL = BASE_URL + "orgs/" + orgName + "/repos?access_token="+github.getAccessToken();                                                                                                              ;
//
//        assertNotNull(github.allReposForOrg(orgName));
//    }
//
//    @Test
//    public void testPullsForRepo() throws Exception {
//         assertNotNull(github.allPullsForRepo("https://api.github.com/repos/Netflix/asgard/pulls"));
//    }

    protected Resource jsonResource(String filename) {
        return new ClassPathResource(filename + ".json", getClass());
    }
}
