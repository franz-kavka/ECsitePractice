<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv="Content-Script-Type" content="text/javascript">
	<meta http-equiv="imagetoolbar" content="no">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>BuyItem画面</title>
	<style type="text/css">
		body{
		margin:0;
		padding:0;
		line-height:1.6;
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

		#footer{
		width: 100%;
		height: 80px;
		background-color: black;
		clear:both;
		text-align:center;
		min-height: 100%;
  		display: flex;
  		flex-direction: column;
		}
		#buy{
		border:1px solid black;
		margin:10px;
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
	#menu{
		font-size:12px;
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
		display: inline-block;
		}
		#formtop{
		display:inline-block;
		padding-left:5px;
		padding-right:6px;

		}
		#formtopcart{
		display:inline-block;
		margin:0.5em 2em;
		text-align:right;
		 float: right;

		}
		#cart {
    display: inline-block;
    padding: 0.5em 1em;
    text-decoration: none;
    height:70px;
    width:200px;
    color: white;
    background:black;
    border: double 1px #67c5ff;
    border-radius: 3px;
    transition: .4s;
}
#cart:hover {
    background: #00bcd4;
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

				<form id="formtopcart" action="CartAction">
					<input type="hidden" value="Cart"/>
					<s:if test="session.cnt == 0"><input type="submit" id="cart" value="カートが空です"/></s:if>
					<s:else>
					<input type="submit" id="cart" value="カートの内容：<s:property value="session.cnt"/>"/>
					</s:else>
				</form>

			</s:if>
			<s:else>
				<form id="formtop" action="LoggingAction">
					<input type="submit" id="menu" value="Login"/>
				</form>
				<form id="formtopcart" action="LoginAction">
					<input type="submit" id="cart" value="カートが空です"/>
				</form>
			</s:else>
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:iterator value="session.BuyItemDTOList">
				<div id="buy">
					<form action="CartAddAction" method="post">
					<table>
						<tr>
							<td>
								<span>商品名</span>
							</td>
							<td>
								<s:property value="itemName"/><br>
							</td>
						</tr>
						<tr>
							<td>
								<span>値段</span>
							</td>
							<td>
								<s:property value="itemPrice"/><span>円</span>
							</td>
						</tr>
						<tr>
							<td>
								<span>購入個数</span>
							</td>
							<td>
								<select name="count">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<span>支払い方法</span>
							</td>
							<td>
								<input type="radio" name="pay" value="1" checked="checked">現金払い
								<input type="radio" name="pay" value="2">クレジットカード
							</td>
						</tr>
						<tr>
							<td>
								<s:submit id="submit" value="カートに追加"/>
							</td>
						</tr>
					</table>



					<input type="hidden" name="itemName" value='<s:property value="itemName"/>'>
					<input type="hidden" name="itemPrice" value='<s:property value="itemPrice"/>'>
					<input type="hidden" name="id" value='<s:property value="id"/>'>

					</form>
				</div>
			</s:iterator>
			<div>
			<div id="back">
				<form id="formtop" action="GoHomeAction">
					<input type="submit" id="submit" value="戻る"/>
				</form>
				<br><br>
			</div>
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