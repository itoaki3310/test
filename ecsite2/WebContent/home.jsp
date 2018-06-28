<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- taglibでStruts内のSタグを使用できるように設定 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<!-- 言語設定 -->
	<meta charset="utf-8" />

<title>Home画面</title>
<!-- cssの設定 -->
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
<!-- headerとmainとfooterは必須(中身は不要) -->
<body>

	<div id="header"><jsp:include page="header.jsp" /></div>
	<div id="main">
		<p>Home</p>
		<div id=text-center>

<!-- s:formタグのActionはaction属性で定義されたアクション
(今回で言うとHomeAction)へとフォームの内容を送信する。 -->
			<s:form action="HomeAction">

<!-- s:submitでボタンの生成をする。value内の文字をボタンに表示する
　　今回はs:form内なのでボタンを押すとHomeActionに送信される -->
				<s:submit value="商品購入"/>
			</s:form>

<!-- s:ifはtest=""の中身がtureならタグ内の処理を表示するという意味 -->
			<s:if test="#session.id !=null">
				<p>ログアウトするなら

<!-- s:urlはaction内の場所へ送信するという意
	<a hrefはこれから言うurlに飛ばすぞという意味-->
				<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</s:if>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>