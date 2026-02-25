<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Welcome to servlet tut for youtube</title>

<link rel="stylesheet" href="<%= application.getContextPath() %>/css/style.css"/>
</head>
<body>
<div class="container">
     <%@ include file ="menu.jsp" %>

<h1>
welcome to servlet crash course
</h1>
<p> this is vert informational video about servlet</p>

<form action="<%= application.getContextPath() %>/third" method="post">

<input name="message" type="text" placeholder="enter the text" />

<button type="submit">submit</button>


</form>


<form action="s1">

N1 : <input type="number" name ="n1">
<br>

N2 : <input type="number" name ="n2">
<br>

<button type="submit">
       
       ok
       
</button>

</form>

</div>
</body>
</html>  