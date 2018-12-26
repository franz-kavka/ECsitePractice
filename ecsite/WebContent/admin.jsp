<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Admin</title>
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
	height: 85px;
	background-color: black;
}
#main {
	width: 100%;
	height: 95%;
	text-align: center;
}
#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear:both;
	text-align:center;
	min-height: 100%;
  display: flex;
  flex-direction: column;
}
#yuza{
	border:1px solid black;
	text-align:right;
	display:inline-block;
	padding:50px;
	margin:20px;
}
#syouhin{
	border:1px solid black;
	display:inline-block;
	padding:50px;
	margin:20px;
}
#lefty{
	text-align:left;
	display:inline-block;
}
#righty{
	text-align:left;
	display:inline-block;
}
#title{
	margin:0 auto;
	width:100px;
	text-align:center;
	background-color:white;
	position:relative;
	top:40px;
}
#submit{
    display: inline-block;
    padding: 0.3em 1em;
    text-decoration: none;
    color: black;
    border: solid 1px black;
    border-radius: 3px;
    transition: .4s;
    background:white;
		}
	#submit:hover {
	background: black;
    color: white;
	}
	#menu{
		display: inline-block;
    	text-decoration: none;
    	background: black;
    	color:white;
    	font-size:12px;
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
				<p>Administration</p>
			</div>
			<div>
				<h3>管理者画面</h3>
				<div id="lefty">
					<div id="title">
					<p>商品</p>
					</div>
						<div id="syouhin">
							<s:form action="ItemCreateAction">
								<s:submit id="submit" value="新規登録"/>
							</s:form>
							<s:form action="ItemListAction">
								<p><s:submit id="submit" value="一覧"/></p>
							</s:form>
						</div>
					</div>
					<div id="righty">
						<div id="title">
						<p>ユーザー</p>
						</div>
				<div id="yuza">
					<s:form action="UserCreateAdminAction">
						<s:submit id="submit" value="新規登録"/>
					</s:form>
					<s:form action="UserListAction">
						<p><s:submit id="submit" value="一覧"/></p>
					</s:form>
				</div>
				</div>
				<div id="center">
					<div id="title">
						<p>注文</p>
					</div>
				<div id="yuza">
				<s:form action="OrderListAction">
						<p><s:submit id="submit" value="一覧"/></p>
					</s:form>
				</div>
				</div>

		<div id="text-right">

		</div>
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