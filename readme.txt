help tips
how to login step by step
create springboot app and deploy. update redeploy https://www.youtube.com/watch?v=UWeIxJcaUbQ (complete login and springboot app)

https://www.youtube.com/watch?v=UWeIxJcaUbQ (best)
Web UI steps:
https://login.run.pivotal.io/
[Right top] corner: sign-in
[Left side] Pivotal Web Services

Then you see the screen/page with 
Orgs name [developandLearn]  ==> spaces { development, experiment}
under development 1 app spring-cloudfoundry (stopped state)
		
====================================

C:\Temp\Cloud\toCloud\cf-sample-app-spring>cf login -a https://api.run.pivotal.i
o
API endpoint: https://api.run.pivotal.io

Email: subra.dass@gmail.com

Password:
Authenticating...
OK
------------------------------------------next step-----------------
C:\Temp\Cloud\toCloud\cf-sample-app-spring>cf push
Pushing from manifest to org DevelopandLearn / space development as subra.dass@g
mail.com...
Using manifest file C:\Temp\Cloud\toCloud\cf-sample-app-spring\manifest.yml
Getting app info...
Creating app with these attributes...
+ name:         cf-demo
  path:         C:\Temp\Cloud\toCloud\cf-sample-app-spring
  buildpacks:
+   https://github.com/cloudfoundry/java-buildpack.git
+ instances:    1
+ memory:       768M
  routes:
+   cf-demo-rested-hyena.cfapps.io

Creating app cf-demo...
. . . . .
Waiting for app to start...

name:              cf-demo
requested state:   started
routes:            cf-demo-rested-hyena.cfapps.io
last uploaded:     Thu 28 Nov 12:31:13 EST 2019
stack:             cflinuxfs3
buildpacks:        https://github.com/cloudfoundry/java-buildpack.git

type:            web
instances:       1/1

Targeted org DevelopandLearn

Targeted space development


API endpoint:   https://api.run.pivotal.io (API version: 3.77.0)
User:           subra.dass@gmail.com
Org:            DevelopandLearn
Space:          development

C:\Temp\Cloud\toCloud\cf-sample-app-spring>pwd
-------------------------------- alternatively--------------
step-1
C:\Temp\Cloud\toCloud\cf-sample-app-spring>cf api https://api.run.pivotal.io
Setting api endpoint to https://api.run.pivotal.io...
OK

api endpoint:   https://api.run.pivotal.io
api version:    3.77.0

C:\Temp\Cloud\toCloud\cf-sample-app-spring>cf login
step-2
C:\Temp\Cloud\toCloud\cf-sample-app-spring>cf login
API endpoint: https://api.run.pivotal.io

Email: subra.dass@gmail.com

Password:
Authenticating...
OK

Targeted org DevelopandLearn

Targeted space development



API endpoint:   https://api.run.pivotal.io (API version: 3.77.0)
User:           subra.dass@gmail.com
Org:            DevelopandLearn
Space:          development

C:\Temp\Cloud\toCloud\cf-sample-app-spring>
------------------ step 3 after login 
on same console that I logged on
C:\Temp\Cloud\toCloud\cf-sample-app-spring
now
cd C:\Users\sdass\STS\2019workspace\spring-cloudfoundry
now push


C:\Users\sdass\STS\2019workspace\spring-cloudfoundry>cf push spring-cloudfoundry
 -p target\spring-cloudfoundry-0.0.1-SNAPSHOT.jar
------------------------

other commands
cf apps -- list all apps under my space <- on that domain
cf app spring-cloudfoundry -- gives more details on paricular app
cf marketplace -- what services are available (e.g rediscloud)
cf marketplace  -s rediscloud --s for specify
the plan at the bottom 30mb is free plan
cf create-service -- gives help lines for service creation
spring-cloudfoundry>cf create-service rediscloud 30mb demo-free-redis
Creating service instance demo-free-redis in org DevelopandLearn / space develop
ment as subra.dass@gmail.com...
OK
cf services -- shows list of services
--------------------------
update application with /redis end point. build.
on 2nd terminal
cf logs spring-cloudfoundry -- log will be tail -f
Retrieving logs for app spring-cloudfoundry in org DevelopandLearn / space devel
opment as subra.dass@gmail.com...

redeploy result
C:\Users\sdass\STS\2019workspace\spring-cloudfoundry>cf push spring-cloudfoundry 

--no-start
 -p target\spring-cloudfoundry-0.0.1-SNAPSHOT.jar
Pushing app spring-cloudfoundry to org DevelopandLearn / space development as su
bra.dass@gmail.com...
Getting app info...
Updating app with these attributes...
Uploading files...
 1.50 MiB / 1.50 MiB [=============================================] 100.00% 4s
name:              spring-cloudfoundry
requested state:   started
routes:            spring-cloudfoundry.cfapps.io
- - - - - - - 
spring-cloudfoundry>cf bind-service spring-cloudfoundry  demo-free-redis
OK
TIP: Use 'cf restage spring-cloudfoundry' to ensure your env variable changes take 

effect
--- application not started. so just start. Pushed already done
cf start spring-cloudfoundry