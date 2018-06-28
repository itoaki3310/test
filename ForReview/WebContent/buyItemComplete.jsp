<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buy item comlete!</title>
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
	#table {
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

	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>buy item complete!</p>
		</div>

	<div id="table">
		<p>購入手続き完了</p>
		<a href='<s:url action="MyPageAction"/>'>My Page</a><span>からの購入が可能です</span>
		<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
	</div>
	</div>
		<div id="footer"></div>

</body>
</html>