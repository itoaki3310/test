<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理ページ</title>
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
			<p>商品管理ページ</p>
		</div>
			<h3>登録商品情報は以下になります</h3>
			<table border="1">
			<tr>
				<th>品名</th>
				<th>値段</th>
				<th>在庫個数</th>
				<th>カテゴリ</th>
			</tr>
<%--s:iteratorはリストの中身を表示する --%>
			<s:iterator value="imList">
				<s:form action="ItemDeleteAction">
				<tr>
				<td><a href='<s:param name="id" value="%{id}"/>'>
				<s:submit value="削除" /></a></td>
				<td><s:property value="itemName" /></td>
				<td><s:property value="itemPrice" /><span>円</span></td>
				<td><s:property value="itemStock" /><span>個</span></td>
				<td><s:property value="itemCategory"/></td>
				</tr>
				</s:form>

			</s:iterator>
			</table>
				<s:form action="ItemManageAction">
					<input type="hidden" name="deleteAllItem" value="1">
					<s:submit value="一括削除" method="delete" />
				</s:form>

		<div id="text-right">
			<p>ManagerPageへ戻る場合は<a href='<s:url action="GoManagerAction" />'>こちら</a></p>
			<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
		</div>
	</div>
		<div id="footer"></div>

</body>
</html>