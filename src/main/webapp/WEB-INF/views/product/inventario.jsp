<%@ include file="../includes/header.jsp" %>


    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${fecha}"/></p>
    <h3>Productos</h3>
    <li><a href="<c:url value="/product/incremento-precio.html"/>">Incrementar Precio</a></li>
    <li><a href="<c:url value="/iventario/nuevo"/>">Crear nuevo</a></li>
    <c:forEach items="${products}" var="prod">
      <c:out value="${prod.description}"/> 
      <i>$<c:out value="${prod.price}"/></i>
      <a href="inventario/detalle/${prod.id}" }>Detalle</a>
      <a href="inventario/eliminar/${prod.id}">Eliminar</a>
      <br><br>
    </c:forEach>

<a href="">Atras</a>
<%@ include file="../includes/footer.jsp" %>