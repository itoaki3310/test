<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録ページ</title>
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
	#text-right {
		display: inline-block;
		text-align: right;

	}
</style>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>商品登録ページ</p>
		</div>
		<s:form action="ItemCreateConfirmAction">
		<!-- confilmActionの宣言文と対応 -->

			<tr><td><label>item name:</label></td>
			<td><input type="text" name="itemName" value=""/></td></tr>

			<tr><td><label>item price:</label></td>
			<td><input type="text" name="itemPrice" value=""/></td></tr>

			<tr><td><label>item stock:</label></td>
			<td><input type="text" name="itemStock" value=""/></td></tr>

			<tr><td><label>item category:</label></td>
			<td><input type="text" name=itemCategory value=""/></td></tr>



			<s:submit value="登録"/>
			</s:form>

		<div id="text-right">
			<p>ManagerPageへ戻る場合は<a href='<s:url action="GoManagerAction" />'>こちら</a></p>
			<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
		</div>
	</div>
		<div id="footer"></div>

</body>
</html>