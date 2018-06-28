<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
<title>管理者page</title>
<style type="text/css">

	body {
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana, Helvetica, sans-serif;
		font-size:12px;
		color:#333;
		background:#fff;
	}
	table {
		text-align:center;
		margin:0 auto;
	}

	#top {
		width:780px;
		margin:30px auto;
		border:1px solid #333;
	}
	#header {
		width: 100%;
		height: 80px;
		background-color: black;
	}
	#main {
		width: 100%;
		height: 500px;
		text-align: center;
	}
	#footer {
		width: 100%;
		height: 80px;
		background-color: black;
		clear:both;
	}
	#text-center {
		display: inline-block;
		text-align: center;
	}
</style>

</head>
<body>
	<div id="header"></div>
		<div id="main">
			<div id="top">
			<p>ManagerPage</p>
			</div>
			<div id=”text-center”>
				<p><a href='<s:url action="UserManageAction"/>'>ユーザー管理ぺージへ</a></p>
				<p><a href='<s:url action="UserCreateAction" />'>ユーザー登録ページへ</a></p>
				<p><a href='<s:url action="ItemManageAction"/>'>商品管理ページへ</a></p>
			<p><a href='<s:url action="ItemCreateAction"/>'>商品登録ぺージへ</a></p>
			<s:if test="#session.id != null">
				<p><a href='<s:url action="LogoutAction" />'>ログアウト</a></p>
			</s:if>
			</div>
		</div>
	<div id="footer"></div>
</body>
</html>