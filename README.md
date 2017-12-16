[![Build Status](https://travis-ci.org/bibryam/semat.svg?branch=master)](https://travis-ci.org/bibryam/semat)
[![CocoaPods](https://img.shields.io/cocoapods/l/AFNetworking.svg)]()
### SEMAT - The Essence Kernel Manager

*A showcase application to demonstrate capabilities of [Apache ISIS](http://isis.apache.org/) project by implementing [OMG SEMAT Essence Kernel](http://www.omg.org/spec/Essence/1.0/PDF) model and running it on Red Hat OpenShift*

### Live Demo on Red Hat OpenShift

See live demo running on a free OpenShift Online account at [http://semat.ofbizian.com](http://semat.ofbizian.com/) or direct URL (may be outdated) [http://semat-semat.193b.starter-ca-central-1.openshiftapps.com/](http://semat-semat.193b.starter-ca-central-1.openshiftapps.com/) 

### Screenshot

![project view](https://1.bp.blogspot.com/-t1q9q2xaP6Q/WBmgyZ-7rnI/AAAAAAAAGn8/cKWm8rg-UysGxRQucrxvnnwOmcwxhgO1QCLcB/s1600/Screen%2BShot%2B2016-11-02%2Bat%2B08.05.16%2B1.png)
![project diagram](https://4.bp.blogspot.com/-mRO2ko-xDPw/Wi29Q4tRY8I/AAAAAAAAJzU/Z0yzBAmxTcY1xi_CKjChf3J2Kc0IM3ifwCLcBGAs/s1600/semat.png)

### Application Features
 - Manage multiple projects per tenant
 - Manage project Alpha states
 - Custom Essence Alpha state list per tenancy
 - Custom Essence Checklist items per tenancy
 - Alpha state spider/radar diagram

### Apache Isis Features used
 - Automatic Apache Wicket based UI generation from domain model
 - Automatic REST API generation from the same domain model
 - Self Signup/Registration
 - Multi Tenancy
 - LDAP integration
 - Auditing
 - Session logging
 - Internationalization

### Build and Run

#### (option 1) Local: build and run with Maven
    mvn clean install
    cd webapp
    mvn jetty:run

#### (option 2) Local: build and run with Docker
    mvn clean install
    docker build --rm -t bibryam/semat .
    docker run -p 8080:8080 bibryam/semat

#### (option 3) Local: build and run with Maven and Docker plugin
    mvn clean install
    cd webapp
    mvn clean install docker:build docker:start -Pdocker

#### Local login
    http://localhost:8080/

    user:user - a default tenant user with two example projects and configuration.
    admin:admin - admin user with full access but no part of any tenancy.

#### (option 4) OpenShift Online: Deploy existing Docker image to OpenShift
Create an OpenShift Online [account](https://manage.openshift.com/). Notice, even the free tier account is enough to try out the application.
Install OpenShift client locally (oc) and login to OpenShift. The following commands will run the latest SEMAT Docker image and expose its URL to outside world. 

    oc new-project semat
    oc new-app bibryam/semat:latest -e CATALINA_OPTS=“-Xmx300m”
    oc expose service semat

The process takes some time as it has to download the Docker images and there are not much free resources on a free tier account. Notice also we limit Tomcat heap size in order to run in a Docker container with 512MB memory.
After few minutes, you should be able to access your SEMAT instance on a URL like this one:URL [http://semat-semat.193b.starter-ca-central-1.openshiftapps.com/](http://semat-semat.193b.starter-ca-central-1.openshiftapps.com/)

### (option 5) OpenShift Online: Deploy to OpenShift from source code
If you do not trust Docker images build by others (you should not!) then you can build your own Docker image as shown above with options 2 and 3 and push it your own docker registry and create the app from it: oc new-app your_name/semat:latest -e CATALINA_OPTS=“-Xmx300m”
Alternatively, you could avoid installing and running Docker completly, and have the source code and the docker image build on OpenShift.
That is called OpenShift Source-to-Image [approach](https://docs.openshift.com/enterprise/3.0/using_images/s2i_images/index.html).
You can do this from OpenShift UI by using for example "Red Hat JBoss Web Server 3.1 Tomcat 8 1.0" template and pointing to the SEMAT github repo.

Or use the template provided here:

    oc create -f semat-openshift-template.json
    oc process semat
      
Using source to image approach allows setting up webhooks, have a Red Hat base image, have jolokia added, memory configuration done, etc.
 


