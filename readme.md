# Securing Spring Jersey (JAX-RS) REST APIs using Auth0 
This project repository contains the start pack components for setting up a REST Service using Spring Boot and Jersey (Tomcat) secured with Spring Security and Auth0.
	
If you already have account with auth0 you can skip this step else you have to sign up auth0 for Authentication, Identity Management, SSOs and many. Click this link [Signup](https://auth0.com/signup).
	
Step 1: In Auth0 Dash board Create a Client.

Step 2: Create an Custom API 

Step 3: Create Scopes for the API, in this example, `JerseySecurityConfig.java` I have added the `hasAuthority("authorize:post")` and `hasAuthority("authorize:get")` for secure POST and GET method respectively. Change the scope of your requests when required.

Step 4: Add the following URLS to your callback in client settings for generating new access token. You can ignore this step if you have front end client UI Application with Angular or React.
1. `http://auth0.digituz.com.br/` and
2. `http://auth0.digituz.com.br/callback` 
		
Step 5: Generate new Access Token for you Application using this [URL](http://auth0.digituz.com.br/http-client)
		
Step 6: Get the access token from your browser local storage. 

Step 7: Configure you API scope authorization in the `JerseySecurityConfig.java` file.   
	
`HelloServiceResource.java` This file contains the resource representations of REST APIs.
	
Run the backend APIs by this command, `gradle bootRun`
	
 
