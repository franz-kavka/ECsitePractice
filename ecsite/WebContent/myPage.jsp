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
<title>MyPage画面</title>
<style>
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
	border-collapse: collapse;s
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
	#inline{
	display:inline;
	}

</style>
</head>
<body>
	<div id="header">
		<div id="pr">
				<form id="formtop" action="LogoutAction">
					<input type="submit" id="menu" value="Logout"/>
				</form>
		</div>
	</div>
		<div id="main">
			<div id="top">
				<p>MyPage</p>
			</div>
			<div>
			<s:if test="myPageList==null">
				<h3>ご購入情報はありません。</h3>
			</s:if>
			<s:elseif test="message==null">
				<h3>ご購入情報は以下になります。</h3>
				<table border="1">
				<tr>
					<th>商品名</th>
					<th>値段</th>
					<th>購入個数</th>
					<th>支払い方法</th>
					<th>購入日</th>
					<th>取消</th>
				</tr>
				<s:iterator value="myPageList">
				<tr>
					<td><s:property value="itemName" /></td>
					<td><s:property value="totalPrice" /><span>円</span></td>
					<td><s:property value="totalCount" /><span>個</span></td>
					<td><s:property value="payPay" /></td>
					<td><s:property value="insert_date" /></td>
					<td><s:form action="MyPageDeleteConfirmAction">
					<input type="hidden" name="deleteFlg" value="2">
					<input type="hidden" name="id" value="<s:property value="id"/>">
					<s:submit id="submit" value="削除"/>
				</s:form></td>
				</tr>
				</s:iterator>
				</table>
				合計：<s:property value="session.total" />円
				<br><br>
				<s:form action="MyPageAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit id="submit" value="一括削除"/>
				</s:form>
			</s:elseif>

			<s:if test="message != null">
				<h3><s:property value="message"/></h3>
				<form id="formtop" action="MyPageAction">
					<input type="submit" id="submit" value="戻る"/>
				</form>
			</s:if>
			<br><br><br><br><br>
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