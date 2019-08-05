<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="styles/style.css">
<meta charset="ISO-8859-1">
<title>CRUD index</title>
</head>
<body>

<div class="container">


 
<nav class="navbar navbar-expand-lg navbar-light bg-chido">
  <a class="navbar-brand" href="#">CRUD</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Inicio</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Create.jsp">Create product</a>
      </li>
      
       <li class="nav-item">
        <a class="nav-link" href="Delete.jsp">Delete product</a>
      </li>
      
       <li class="nav-item">
        <a class="nav-link" href="Read.jsp">Read product</a>
      </li>
      
       <li class="nav-item active">
        <a class="nav-link" href="Update.jsp">Update product</a>
      </li>
     
    </ul>
   
  </div>
</nav>
<h1>Update product</h1>
<form action="UpdateServlet" method="get">
	<p>
		<label for="txtIdProducto">id del producto</label>
		<input type="text" id="txtIdProducto" name="txtIdProducto">
	</p>
	
	<p>
		<label for="txtExistenciaProducto">Existencia del producto</label>
		<input type="text" id="txtExistenciaProducto" name="txtExistenciaProducto">
	</p>
	<br>
	<input type="submit" class="btn btn-secondary" value="Guardar">

</form>


</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>