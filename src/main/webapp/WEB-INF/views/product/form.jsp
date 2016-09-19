<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Nuevo producto</title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1>Crear producto</h1>

<form:form action="nuevo" method="post" commandName="product">
	
	<label for="id">Id</label>
	<form:input path="id"/>
	<form:errors path="id" cssClass="error"/>
	<br>
	<label for="description">Description</label>
	<form:input path="description" placeholder="Minimo 3 caracteres"/>
	<form:errors path="description" cssClass="error"/>
	<br>
	<label for="price">Price</label>
	<form:input path="price"/>
	<form:errors path="price" cssClass="error"/>
	<br>

<input type="submit" value="Crear">
</form:form>

<a href="../product/inventario">Atras</a>


</body>
</html>