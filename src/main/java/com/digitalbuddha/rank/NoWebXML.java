package com.digitalbuddha.rank;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created with IntelliJ IDEA.
 * User: Nakhimovich
 * Date: 3/10/14
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoWebXML extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}