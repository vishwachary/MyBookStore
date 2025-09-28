since we are using H2 in memory database

CREATE USER MY_LIBRARY PASSWORD 'rush2##2hsur';
SELECT * FROM INFORMATION_SCHEMA.USERS WHERE USER_NAME = 'MY_LIBRARY';
ALTER USER MY_LIBRARY ADMIN TRUE

Then logout from sa user
and login with
<img width="455" height="383" alt="image" src="https://github.com/user-attachments/assets/299d0160-10ed-40bd-9dd3-1d4b1e640f76" />



# MyBookStore
MyBookStore-With-Oauth2-and-JWT
Step 1

Go to Google Cloud Console   :  https://console.cloud.google.com/

Create a project -  MyBookStore

Enable Google OAuth2 API.

Create OAuth 2.0 credentials (Client ID & Secret).

remember while creating OAuth 2 credentials , please give the below as redirect url

Add http://localhost:8080/login/oauth2/code/google as redirect URI.

Once , this is done , you will get Client Id and Client Secret , There will be an option to download JSON , which has all the information w.r.t 
Client ID and Client Secret and other information like redirect URL , auth token url..

==================Next Steps ==================
Flow in Your Current Design

User logs in with Google (OAuth2).

Spring Security redirects them to Google.

Google validates credentials and returns user info (ID token with email, profile, etc.).

Spring Boot receives user info.

You extract the Gmail address.

You decide what role that email should have (ADMIN or USER).

Spring Boot issues its own JWT.

This JWT includes your app’s claims (roles, expiration, subject, etc.).

This is the token the frontend uses for all subsequent REST API calls (e.g. /api/books).

Spring Boot validates JWT on every API call.

Since it issued the JWT, it knows the secret key to validate it.

Checks the roles claim → decides whether to allow GET/POST/DELETE.
