package com.digitalbuddha.rank.controller;

import com.digitalbuddha.rank.model.Repository;
import com.digitalbuddha.rank.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GitHubController {
    @Autowired
    RestService restService;

    @RequestMapping(value = "/org/{organization}/top/{returnCount}/repos",method=RequestMethod.GET)
    public Repository[] top5forOrganization(@PathVariable String organization, @PathVariable int returnCount) {
        return restService.findTop5ReposByPullCount(organization, returnCount, false);
    }
    @RequestMapping(value = "/org/{organization}/top/{returnCount}/repos/expanded",method=RequestMethod.GET)
    public Repository[] top5forOrganizationExpnded(@PathVariable String organization, @PathVariable int returnCount) {
        return restService.findTop5ReposByPullCount(organization, returnCount, true);
    }

}
