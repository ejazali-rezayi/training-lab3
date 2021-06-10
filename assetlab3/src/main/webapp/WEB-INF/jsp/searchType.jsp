<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Search by Type</title>
        <style type="text/css">
        	h2 {margin-left: 20px;}
        </style>
    </head>
    <body>
    	<h2>Search by Type</h2>
    	<form action="displayType" method="GET">
			
			<label for="fname">Asset type: </label>
			<input type="text" name="type" placeholder="Asset type"/>		
			<br>
			<br>
			<input type="submit" value="Search type"/>
		</form>
		<a href="display"><button type="submit">Return to display of all assets</button></a>
    
    </body>
</html>