<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Search by Name</title>
        <style type="text/css">
        	h2 {margin-left: 20px;}
        </style>
    </head>
    <body>
    	<h2>Search by Name</h2>
    	<form action="displayName" method="GET">
			
			<label for="fname">Asset name: </label>
			<input type="text" name="name" placeholder="Asset name"/>		
			<br>
			<br>
			<input type="submit" value="Search type"/>
		</form>
		<a href="display"><button type="submit">Return to display of all assets</button></a>
    
    </body>
</html>