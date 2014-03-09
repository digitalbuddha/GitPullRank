package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class BaseTestCase {
    public final String NETFLIX = "netflix";

    public MockRestServiceServer mockServer;
    public static final String BASE_URL = "https://api.github.com/";

    @Autowired
    GitHubClient github;
    @Autowired
    RestService restService;

    @Test
    public void sampleTest() throws Exception {

    }

    protected Resource jsonResource(String filename) {
        return new ClassPathResource(filename + ".json", getClass());
    }

    public void createPullResponse(String pullURL) {
        if(mockServer==null)
        mockServer = MockRestServiceServer.createServer(github);
        pullURL=pullURL.replace("{/number}","");
        mockServer.expect(requestTo(pullURL + "?access_token=" + github.getAccessToken()))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("pulls"), MediaType.APPLICATION_JSON)
                );
    }
    public void createReposResponse(String orgName) {
        final String allReposURL = BASE_URL + "orgs/" + orgName + "/repos?access_token=" + github.getAccessToken();
        if(mockServer==null)
        mockServer = MockRestServiceServer.createServer(github);
        mockServer.expect(requestTo(allReposURL))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("repos"), MediaType.APPLICATION_JSON)
                );
    }
}
