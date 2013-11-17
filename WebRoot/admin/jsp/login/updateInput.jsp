<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <script src="js/jquery-1.7.1.js" type="text/javascript"></script>
	<link href="admin/images/skin.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>admin/jsp/login/js/LoginCheck.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #EEF2FB;
	}
	-->
	</style>
  </head>
  
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="admin/images/mail_leftbg.gif"><img src="admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="admin/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">修改密码</div></td>
	      </tr>
	    </table></td>
	    <td width="16" valign="top" background="admin/images/mail_rightbg.gif"><img src="admin/images/nav-right-bg.gif" width="16" height="29" /></td>
	  </tr>
	  <tr>
	    <td valign="middle" background="admin/images/mail_leftbg.gif">&nbsp;</td>
	    <td valign="top" bgcolor="#F7F8F9">
	    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table border="0" cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td>
							<form name="myform" action="javascript:updateInputOnClick()" method="post">
		                        <table align="center" width="420" border=0>
		                          <tr>
		                            <td width="19%">用户名：</td>
		                            <td colspan="2"><input name="username" id="username" size="20" onBlur="q_username()" maxLength="11">
		                            <span id="s_username" class="login_txt"></span>
		                            </td>
		                          </tr>
		                          <tr>
		                            <td>旧密码：</td>
		                            <td colspan="2"><input id="password" type="password" size="20" name="password" onBlur="c_password()" maxLength="11">
		                              <span id="s_password" class="login_txt"></span>
		                              </td>
		                          </tr>
		                          <tr>
		                            <td>验证码：</td>
		                            <td colspan="2"><input name=rand id=rand type=text value="" maxLength=4 size=10 onBlur="c_rand()">
		                            <img src="Rand" id="randCode" title="看不清楚？请点击这里！" onClick="refreshRand()"/>
		                            <span id="s_rand" class="login_txt"></span>
		                            </td>
		                          </tr>
		                          <tr>
		                            <td height="40" >&nbsp;</td>
		                            <td width="27%" height="35" ><input name="login" type="submit" class="button" id="login" value="提交"> </td>
		                            <td><input name="cs" type="button" class="button" id="cs" value="取 消" onClick="move()"></td>
		                          </tr>
		                        </table>
		                        <br>
		                    </form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	    </table></td>
	    
	    
	    <td background="admin/images/mail_rightbg.gif">&nbsp;</td>
	  </tr>
	  <tr>
	    <td valign="bottom" background="admin/images/mail_leftbg.gif"><img src="admin/images/buttom_left2.gif" width="17" height="17" /></td>
	    <td background="admin/images/buttom_bgs.gif"><img src="admin/images/buttom_bgs.gif" width="17" height="17"></td>
	    <td valign="bottom" background="admin/images/mail_rightbg.gif"><img src="admin/images/buttom_right2.gif" width="16" height="17" /></td>
	  </tr>
	</table>
	</body>
</html>
