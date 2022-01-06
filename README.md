# JWT-Spring-Boot-Security
this repository contains all the modules related JWT(java web tokenization) using Spring boot Security as branches of the repository.

Steps to create JWT token 

>Create project with spring web, spring security dependency that will provide simple form login authentication.
>add jjwt and xml binder dependency from maven repository for jwt token generation.
>make config class and  enable WebSecurity using annotation and make AuthenticationManager, PasswordwordEncoder beans also override configure methods with AuthenticationBuilder and Http parameters
>make JwtTokenUtil class and get source code from internet that class provides following functionality:
  >>generate token for user
  >>retrieve username from jwt token
  >>retrieve expiration date from jwt token 
  >>retrieveing any information from token we will need the secret key
  >>check if the token has expired
  >>while creating the token 
    >>>Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    >>> Sign the JWT using the HS512 algorithm and secret key.
    >>>According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1) compaction of the JWT to a URL-safe string
  >>validate token

