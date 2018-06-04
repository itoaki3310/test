<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WELCOME</title>
</head>
<body>
name and password please
<s:form action="LoginAction">
	<s:textfield name="username" label="username:"/>
	<s:password name="password" label="pass"/>
	<s:submit value="sent"/>
</s:form>
</body>
</html>