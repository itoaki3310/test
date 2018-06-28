<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー管理ページ</title>
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
			<p>ユーザー管理ページ</p>
		</div>
<!-- 現在の登録ユーザー管理＆リスト -->
		<s:if test="userlist==null">
			<h3>ユーザー情報はありません</h3>
		</s:if>
		<s:elseif test="userlist>=0">
			<h3>ユーザー情報は以下になります</h3>
			<table border="1">
			<tr>
				<th>id</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>UserName</th>
				<th>登録日</th>
			</tr>

			<s:iterator value="userManageList">
				<tr>
					<td><s:property value="Id" /></td>
					<td><s:property value="login_id" /></td>
					<td><s:property value="login_pass" /></td>
					<td><s:property value="user_name" /></td>
					<td><s:property value="insert_date" /></td>
				</tr>
			</s:iterator>
			</table>
				<s:form action="UserManageAection">
				<!-- ボタンを押すと1を返す -->
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="一括削除" method="delete" />
				</s:form>
		</s:elseif>
		<s:if test="message != null">
			<h3><s:property value="message"/></h3>
		</s:if>

		<!-- 新規ユーザー登録 -->
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

		<div id="text-right">
			<p>ManagerPageへ戻る場合は<a href='<s:url action="GoManagerAction" />'>こちら</a></p>
			<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
		</div>
	</div>
		<div id="footer"></div>

</body>
</html>