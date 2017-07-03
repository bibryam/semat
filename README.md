[![Build Status](https://travis-ci.org/bibryam/semat.svg?branch=master)](https://travis-ci.org/bibryam/semat)
### SEMAT - The Essence Kernel Manager

*An application for describing projects using SEMAT/OMG Essence Kernel model*

### Demo

See live demo at [http://semat.ofbizian.com](http://semat.ofbizian.com/) or try [http://http://146.148.97.68](http://http://146.148.97.68) 

### Screenshot

![project view](https://1.bp.blogspot.com/-t1q9q2xaP6Q/WBmgyZ-7rnI/AAAAAAAAGn8/cKWm8rg-UysGxRQucrxvnnwOmcwxhgO1QCLcB/s1600/Screen%2BShot%2B2016-11-02%2Bat%2B08.05.16%2B1.png)

### (option 1)Build and run locally with Maven
    mvn clean install
    cd webapp
    mvn jetty:run

### (option 2) Build and run locally with Docker
    docker build --rm -t bibryam/semat .
    docker run -p 8080:8080 bibryam/semat

### (option 3) Build and run locally with Maven and Docker
    mvn clean install
    cd webapp
    mvn clean install docker:build docker:start -Pdocker

### Login
    http://localhost:8080/

    user:user - default demo tenanted user with example projects
    admin:admin - admin user with full access but no tenancy

### Feature
 - Self Registration
 - Multi Tenancy
 - LDAP integration
 - Auditing
 - Session logging
 - Internationalization
 - REST API
 - Custom Essence Alpha states
 - Custom Essence Checklist items

### Further Reading
The project is developed using [Apache ISIS](http://isis.apache.org/)

SEMAT Essence Kernel [OMG standard](http://www.omg.org/spec/Essence/1.1/)

### MIT License



