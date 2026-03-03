<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page isErrorPage ="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sorry ! Something went to be wrong </title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
          <div class="container p-3 text-center " >
      <img src="img/error.jpeg" class ="img-fluid"/>
       <h1 class ="display-3"> Sorry ! Something went to be wrong</h1>
       <p><%= exception %></p>
       <a  href="index.jsp" class="btn btn-outline-primary">Home page</a>
       </div>
</body>
</html>