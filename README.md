GitPullRank
===========

Rest Service that returns top N repos for an organization by number of pull requests

Technologies and stuff:
Spring Boot - Fantastic Project starter by Spring, I used web, actuator and test starter dependencies
RestTemplate
Mockito - Used with Spring's MockServer to mock server responses and inject json as result.
Gradle - Love it more every time I use it.  
Git
Intellij

Technologies not used
XML (Spring has really stepped up recently)


Big Ups to Craig Walls who inspired me to work with rest template with all the great work at Spring Social. 
Spring Social Github source code was something I kept referring to especially for the incredible use of a mock server.

Special Thanks to Netflix for giving me the opportunity to interview and assigning a well thought out 

0-60 guide
==================================
Git Clone
cd projectDir
open terminal
if using intellij: 
gradlew idea
open the project file, run the bootrun task
if not
gradlew bootRun



you may also run "gradlew war" to generate a war.

project runs in an embedded tomcat (You can configure port in application.properties)
open your browser and try http://localhost:8084/org/netflix/top/5/repos

netflix and 5 are path variables that can be set to any organization or number of repositories to return

additionally, the following call will return all of the pull records as well 
http://localhost:8084/org/{org}/top/{numberOfResults}/repos/expanded 

To run your own container:
gradlew build
move restRank.war from build/libs to a servlet 3 compatible container, Spring boot offically runs on Tomcat 7.0.52.  

Testing
===================================
Tests for the actual calls are commented out, eventually should be an integration test.
There are mocks set up for a repo and pulls request, this way you don't have to hit the actual api.
TODO:  Create more pulls mock data, currently all the same so ranking is silly.
Test coverage is minimal but gets the job done for now.

Technical Hurdles
====================================
1.  All JSON models were generated using  http://jsongen.byingtondesign.com/,
only issue is that there were a few fields like "private" that cannot have a correspoding variable.
For the time being I excluded the values from the model objects, I can eventually rename all the variables.
Additionally the variables use underscore and not camelHump notation, that also needs to be changed.
2.  Github only allows 60 requests without authentication, I needed to get a personal token which the app is currently using,
if this is to be hosted, an actual token should be used and put into a properties file.

This was a great excercise, I hope to contribute to the Spring Social Github project shortly.

