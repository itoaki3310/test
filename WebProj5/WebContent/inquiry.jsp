<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InquiryForm</title>
</head>
<body>

<s:form method="post" action="InquiryCompleteAction">
	name:<input type="text" name="name"/><br>
	Kind Of Inquiry:<br>

	<select name="qtype" >
		<option value="company">AboutUs</option>
		<option value="product">AboutProducts</option>
		<option value="support">AfterSupport</option>
	</select>

	<br>
	inquiry:
<s:textarea name="body"/>
<br> <s:submit value="登録"/>
</s:form>
</body>
</html>