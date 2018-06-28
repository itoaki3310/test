<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>ItemDeleteConfirm画面</title>
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
</style>

</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>item Delete confirm</p>
		</div>
			<h3>削除内容は以下になります</h3>
			<h3>本当に削除してもよろしいですか？</h3>
			<table>
			<s:form action="ItemDeleteCompleteAction">

		<tr id="box">
			<td><label>item name:</label></td>
			<td><s:property value="#session.itemName"/></td>
		</tr>
		<tr id="box">
			<td><label>item price:</label></td>
			<td><s:property value="#session.itemPrice"/></td>		</tr>
		<tr id="box">
			<td><label>item stock:</label></td>
			<td><s:property value="#session.itemStock"/></td>
		</tr>
		<tr id="box">
		<td><label>item Category:</label></td>
			<td><s:property value="#session.itemCategory"/></td>
		</tr>

			<input type="hidden" name="deleteOneItem" value="1">
			<s:submit value="削除" method="delete"/>

	</s:form>
</table>
	</div>
	<div id="footer">>
	</div>
</body>
</html>
