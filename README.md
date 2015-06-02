#Login Dropwizard Service
This is a sample drop wizard used as a base for teaching new starts about integration and unit testing

##Build and Run
```
mvn package
java -jar target/login-service-1.jar server
```

##Use
Authenticated user request
```console
› curl -X POST -i -H "Content-Type: application/x-www-form-urlencoded" -d 'username=admin&password=password' http://localhost:8080/login
HTTP/1.1 204 No Content
Date: Tue, 02 Jun 2015 16:55:34 GMT
```

Unauthenticated user request
```console
› curl -X POST -i -H "Content-Type: application/x-www-form-urlencoded" -d 'username=admin&password=password1' http://localhost:8080/login
HTTP/1.1 401 Unauthorized
Date: Tue, 02 Jun 2015 16:57:05 GMT
Content-Type: text/html; charset=ISO-8859-1
Cache-Control: must-revalidate,no-cache,no-store
Content-Length: 295

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Error 401 Unauthorized</title>
</head>
<body><h2>HTTP ERROR 401</h2>
<p>Problem accessing /login. Reason:
<pre>    Unauthorized</pre></p><hr><i><small>Powered by Jetty://</small></i><hr/>

</body>
</html>
```
