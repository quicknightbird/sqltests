<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>Table Students </h1>
<h3>Add Student: </h3>
<form>
<input placeholder="First Name" type="text" name ="Firstname" >
<input placeholder="Second Name" type="text" name ="Secondname" >
<input placeholder="Group" type="text" name ="Group" >
<input placeholder="Birthday" type="text" name ="Birthday" >

<button type="submit">Add</button>
</form>

<%
String fn = request.getParameter("Firstname");
String sn = request.getParameter("Secondname");
String g = request.getParameter("Group");
String bd = request.getParameter("Birthday");

%>

<h3>Delete student: </h3>
<input placeholder="Type Student ID" type="text" >
<button type="button">Delete</button>
<br>
<br>
<br>
<button type="button">Show List Students</button>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Group</th>
        <th>Birthday</th>
    </tr>
    <tr>
        <td>1</td>
        <td><%=fn%></td>
        <td><%=sn%></td>
        <td><%=g%></td>
        <td><%=bd%></td>
    </tr>
    <tr>
        <td>2</td>
        <td>Francisco </td>
        <td>Chang</td>
        <td>2332</td>
        <td>02.08.1992</td>
    </tr>
</table>
<%----------------------------------------------------------%>

<%ResultSet bb = (ResultSet) request.getAttribute("students");%>

<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Group</th>
        <th>Birthday</th>
    </tr>
    <tr>
<%    while(true){
        try {
            if (!bb.next()) break;%>
        <td><%= out.print(bb.getString("id")) %></td>
        <td><%= out.print(bb.getString("firstname")) %></td>
        <td><%= out.print(bb.getString("lastname")) %></td>
        <td><%= out.print(bb.getString("grupa")) %></td>
        <td><%= out.print(bb.getString("datee")) %></td>
        <%} catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }%>
    </tr>
</table>
</body>
</html>
