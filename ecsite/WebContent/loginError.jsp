<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Login画面</title>
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
	border-collapse: collapse;
}
#top {
	width:780px;
	margin:30px auto;
	border:1px solid #333;
}
#header {
	width: 100%;
	height: 85px;
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
	text-align:center;
	position:fixed;
	bottom:0;
}
#text-right{
	display:inline-block;
	text-align:right;
}
#menu{
		display: inline-block;
    	text-decoration: none;
    	background: black;
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
		margin:50px;
		}
		#formtop{
		display:inline;
		margin:5px;
		}
		#delete{
    display: inline-block;
    padding: 0.3em 1em;
    text-decoration: none;
    color: black;
    border: solid 1px black;
    border-radius: 3px;
    transition: .4s;
    background:white;
		}
	#delete:hover {
	background: black;
    color: white;
	}
		#submit{
    display: inline-block;
    padding: 0.3em 1em;
    text-decoration: none;
    color: black;
    border: solid 1px #00bcd4;
    border-radius: 3px;
    transition: .4s;
    background:white;
		}
	#submit:hover {
	background: #00bcd4;
    color: white;
	}
</style>
</head>
<body>
	<div id="header">
		<div id="pr">]
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>
		<div>
			<h3>ログインフォーム</h3>
			<s:form action="LoginAction">
				<s:textfield name="loginUserId"/>
				<s:password name="loginPassword"/>
				<s:submit id="submit" value="ログイン"/>
			</s:form>
			<br/>
			<div id="text-link">
				<br><br>
				<form id="formtop" action="UserCreateAction">
					<input type="submit" id="submit" value="新規ユーザー登録"/>
				</form>

			</div>
								<br>
				<h4>IDが存在しないか、パスワードが間違っています。</h4>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		<form id="formtop" action="GoHomeAction">
					<input type="submit" id="menu" value="Home"/>
				</form>
		</div>
	</div>
</body>
</html>