<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisa Exames</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>

<h2>Pesquisa de Exames</h2>

	<s:form action="listByCpf" method="post">
		<s:textfield label="CPF" name="cpf" />
		<s:submit value="Pesquisar" />
	</s:form>

<a href="index.jsp">Exames</a>

<s:if test="exameList.size() > 0">
	<div class="content">
	<table class="exameTable" cellpadding="5px">
		<tr class="even">
			<th>CPF</th>
			<th>Exame</th>
			<th>Resultado</th>
			<th>Unidade Medida</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="exameList" status="exameStatus">
			<tr
				class="<s:if test="#exameStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="cpf" /></td>
				<td><s:property value="nomeExame" /></td>
				<td><s:property value="resultado" /></td>
				<td><s:property value="unidadeMedida" /></td>
				<td><s:url id="editURL" action="editExame">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteExame">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>