<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
     <h2>New Registration</h2>
       <form action="saveReg" method="post">
       <pre>
         Name <input type="text" name="name"/>
         City <input type="text" name="city"/>
         Email <input type="text" name="email"/>
         Mobile <input type="text" name="mobile"/>
         <input type="submit" value="save"/>
       </pre>
        
       </form>
       
       <%
         if(request.getAttribute("msg")!=null){
        	 out.println(request.getAttribute("msg"));
         }
       %>
     
</body>
</html>