<%@ include file="../includes/header.jsp" %>

<form:form action="nuevo" method="post" commandName="product">
	
	<label for="id">Id</label>
	<form:input path="id" disabled="true"/>
	<form:input path="id" hidden="true"/>
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

<a href="product/inventario">Atras</a>

<%@ include file="../includes/footer.jsp" %>