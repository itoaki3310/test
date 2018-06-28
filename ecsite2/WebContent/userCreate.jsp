<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
<title>UserCreate</title>
<Style type="text/css">
	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana,Helvetica,sans-serif;
		color:#333;
		background:#fff;
		}
	table{
		text-align:center;
		margin:0 auto;
	}
	#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;
		text-align:center;
	}
	#header{
		width:100%;
		height:80px;
		background-color:black;
	}
	#main{
		width:100%;
		height:500px;
		text-align:center;
	}
	#footer{
		width:100%;
		height:80px;
		background-color:black;
		clear:both;
	}
</Style>
</head>

<body>
	<div id="header"></div>

	<div id="main">
		<div id="top">
			<p>user create</p>
		</div>
		<s:if test="errorMessage =''">
			<s:property value="errorMessage" escape="false" />
		</s:if>
		<table>
			<s:form action="UserCreateConfirmAction">
			<tr>
				<td><label>login id:</label></td>
				<td><input type="text"name="loginUserId" value=""/></td>
			</tr>
			<tr>
				<td>user pass:</td>
				<td><input type="text" name="loginPassword"value=""/></td>
			</tr>
			<tr>
				<td>user name:</td>
				<td><input type="text" name="UserName"value=""/></td>
			</tr>

			<s:submit value="登録"/>
			</s:form>
		</table>
	</div>
	<div id="footer"></div>
</body>
</html>