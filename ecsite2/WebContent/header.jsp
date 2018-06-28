<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
function GoUserCreateAction(){
	document.getElementById("form").action="GoUserCreateAction";
}
</script>
<title>ヘッダー</title>
<style type="text/css">
#header-title{
	color:white;
	font-size:1.5em;
	float:left;
}
#form{
		float:left;
	}
</style>
</head>
<body>
<header>
<div id="header-title">お試しサイト</div>
<ul>
<s:form id="form" name="form">
	<li><s:submit value="新規登録" classs="submit_btn" onclick="GoUserCreateAction();"/></li>
</s:form>
</ul>
</header>

</body>
</html>