<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<title>Home画面</title>

	<style type="text/css">
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana,Helvetica,sans-serif;
			font-size:12px;
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
		}

		#header{
			width:100%;
			height:85px;
			background-color:black;
		}

		#main{
			width:100%;
			text-align:center;
		}

		#submit{
		display: inline-block;
    	text-decoration: none;
    	background: white;
    	color:black;

    	width: 120px;
    	height: 120px;
    	line-height: 120px;
    	border-radius: 50%;
    	text-align: center;
    	vertical-align: middle;
    	overflow: hidden;
    	box-shadow: 0px 0px 0px 1px white;
    	border: solid 2px #00bcd4;
    	transition: .4s;
		}
		#submit:hover {
		background: #00bcd4;
		color: white;
		}
		#footer{
			width:100%;
		height:80px;
		background-color:black;
		padding:10;
		}

		#text-center{
			display:inline-block;
			text-align:center;
		}
		#aaa{
			width:160px;
			margin:0 auto;
			height:50px;
			font-size:30px;
		}
		#bbb{
			padding:5px;
			background-color:black;
			color:#00bcd4;
			font-size:30px;
		}
		#menu{
		display: inline-block;
    	text-decoration: none;
    	background: black;
    	font-size:12px;
    	color:white;
    	width: 80px;
    	height: 80px;
    	line-height:80px;
    	border-radius: 50%;
    	text-align: center;
    	vertical-align: middle;
    	overflow: hidden;
    	box-shadow: 0px 0px 0px 1px black;
    	border: solid 2px #00bcd4;
    	transition: .4s;
		}
		#menu:hover {
		background: #00bcd4;
		color: white;
		}
		#form{
		display:inline;
		margin:110px;
		}
		#formtop{
		display:inline;
		margin:5px;
		}


	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
			<s:if test="#session.id !=null">
				<form id="formtop" action="LogoutAction">
					<input type="submit" id="menu" value="Logout"/>
				</form>
				<form id="formtop" action="MyPageAction">
					<input type="submit" id="menu" value="MyPage"/>
				</form>
			</s:if>
			<s:else>
				<form id="formtop" action="LoggingAction">
					<input type="submit" id="menu" value="Login"/>
				</form>
			</s:else>
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>

		<div id="text-center">
		<form id="form" action="MyPageAction">
				<input type="submit" id="submit" value="MyPage"/>
			</form>
			<form id="form" action="BuyAction">
				<input type="submit" id="submit" value="Shop"/>
			</form>
		</div>
			<div id="aaa">
			<p>Welcome <span id="bbb">to</span> internous</p>
		</div><br><br><br><br><br><br><br>
		<s:form action="AdminAction">
				<p><s:submit id="submit" value="Admin"/></p>

			</s:form>
			<br><br>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>