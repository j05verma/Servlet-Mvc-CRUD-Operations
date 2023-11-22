<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrations</title>
</head>
<body>
   <h2>All Registrations...</h2>
   <table>
      <tr>
         <th>Name</th>
         <th>City</th>
         <th>Email</th>
         <th>Mobile</th>
         <th>Action</th>
      </tr>
      <%
          ResultSet result=(ResultSet)request.getAttribute("res");
            while(result.next()){
        %>
      <tr>
         <td><%=result.getString(1) %></td>
         <td><%=result.getString(2) %></td>
         <td><%=result.getString(3) %></td>
         <td><%=result.getString(4) %></td>
         <td>
        <!--  space is there then it will not supply the right value of backend -->
         <a href="delete?emailid=<%=result.getString(3)%>">delete</a>
         <a href="update?emailid=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">update</a>
         </td>
      </tr>
          
        <%} %>
      
   </table>
</body>
</html>