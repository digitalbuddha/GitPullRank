package com.digitalbuddha.rank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HelloWorldController {



    @RequestMapping(value = " /organization/{organization}",method=RequestMethod.GET)
    public @ResponseBody String sayHello(@PathVariable String organization) {

        return organization;
    }

}
