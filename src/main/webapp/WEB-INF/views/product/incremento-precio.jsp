<%@include file="../includes/header.jsp" %>


<h1><fmt:message key="priceincrease.title"/></h1>

<a href="">Home</a>

<form:form action="incremento-precio.html" method="post" commandName="priceIncreaseForm">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%"><fmt:message key="increase"/> (%):</td>
        <td width="20%">
          <form:input path="porcentaje"/>
        </td>
        <td width="60%">
          <form:errors path="porcentaje" cssClass="error"/>
        </td>
    </tr>
    <tr>
    	<td>
    		<form:checkbox path="confirmar"/>
    		�Estas Seguro?
    	</td>
    	<td>
    		<form:errors  path="confirmar" cssClass="error"/>
    	</td>    	
    </tr>
        
  </table>
  <br>
  <input type="submit" align="center" value="Ejecutar">
</form:form>



<%@include file="../includes/footer.jsp" %>