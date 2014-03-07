package com.digitalbuddha.rank.service;

import com.digitalbuddha.rank.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: Nakhimovich
 * Date: 3/6/14
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class RestServiceTest  {
    @Autowired
    RestService restService;

    @Test
    public void GetTop5() throws Exception {
        restService.Top5ReposByPullRequest("netflix");
    }
}
