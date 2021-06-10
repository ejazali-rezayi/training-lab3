<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Add item</title>
        <style type="text/css">
        	h2 {margin-left: 20px;}
        	form  { display: table;      }
			p     { display: table-row;  }
			label { display: table-cell; }
			input { display: table-cell; }
        </style>
    </head>
    <body>
    	<h2>Add an item</h2>
    	<form action="addItemToAssets" method="GET">
		
			<p>
				<label for="fname">Asset name: </label>
				<input type="text" name="name" placeholder="Asset Name"/>
			</p>
			<p>
				<label for="fname">Category: </label>
				<input type="text" name="category" placeholder="Category"/>
			</p>
			<p>
				<label for="fname">Position X: </label>
				<input type="text" name="posX" placeholder="Position X"/>
			</p>
			<p>
				<label for="fname">Position Y: </label>
				<input type="text" name="posY" placeholder="Position Y"/>
			</p>
			<p>
				<label for="fname">Position Z: </label>
				<input type="text" name="posZ" placeholder="Position Z"/>
			</p>
			<p>
				<label for="fname">Inspection Date: </label>
				<input type="text" name="inspectionDate" placeholder="Inspection Date"/>
			</p>
			<p>
				<label for="fname">Price: </label>
				<input type="text" name="price" placeholder="Price"/>
			</p>
			<br>
			<br>
			<input id="add-item" type="submit" value="Add item"/>
		</form>
		<a href="display"><button type="submit">Return to display of all assets</button></a>
    
    </body>
</html>