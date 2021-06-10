<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Assets by name</title>
        <style type="text/css">
        	h2 {margin-left:20px}
        	th {padding: 10px}
        	td {padding-left: 10px;
        		padding-right: 10px}
        
        </style>
    </head>
    <body>
    	<h2>Asset List by Name</h2>
        <table>
            <thead>
                <tr>
                	<th>Type</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Position X</th>
                    <th>Position Y</th>
                    <th>Position Z</th>
                    <th>Inspection Date</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
	            <c:forEach items="${asset}" var="asset">
	                <tr>
	                	<td>${asset.getType()}</td>
	                    <td>${asset.getName()}</td>
	                    <td>${asset.getCategory()}</td>
	                    <td>${asset.getPosX()}</td>
	                    <td>${asset.getPosY()}</td>
	                    <td>${asset.getPosZ()}</td>
	                    <td>${asset.getInspectionDate()}</td>
	                    <td>${asset.getPrice()}</td>
	                </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <br>
        <a href="addItem"><button type="submit">Add an item</button></a>
		<br>
		<br>
		<a href="addComponent"><button type="submit">Add a component</button></a>
		<br>
		<br>
		<a href="searchType"><button type="submit">Search by type</button></a>
		<br>
		<br>
		<a href="searchName"><button type="submit">Search by name</button></a>
		<br>
		<br>
		<a href="display"><button type="submit">Return to display of all assets</button></a>
    </body>
</html>