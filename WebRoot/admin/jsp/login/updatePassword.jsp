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
    
    <script src="<%=path %>/js/jquery-1.7.1.js" type="text/javascript"></script>
    <script src="admin/jsp/login/js/LoginCheck.js" type="text/javascript"></script>
    <script src="admin/jsp/login/js/PasswordCheck.js" type="text/javascript"></script>
    
	<link href="admin/images/skin.css" rel="stylesheet" type="text/css" />
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
			
			
		<form method ="post" action="login_update.action" onSubmit="return PasswordCheck()">
    
  <table align="center" width="450" border=0>

  <tr>
  	<td>新密码：</td>
  	<td colspan="2">
  	<input type="password" name="login.password" id="password" onBlur="c_password()" maxLength="11"/>
  		<span id="s_password" class="login_txt"></span>
  	</td>
  </tr>
  <tr>
  	<td>确定新密码：</td>
  	<td colspan="2">
  	<input type="password" id="ConfirmPassword"  onBlur="c_ConfirmPassword()" maxLength="11"/>
  	<span id="s_ConfirmPassword" class="login_txt"></span>
  	</td>
  </tr>
  <tr>
  	 <td width="23%">&nbsp;</td>
  	 <td width="20%" height="35" >
  	 	<input type="hidden" name="id" value="${sessionScope.updateInput.id}" />
  	 	<input type="submit" value="提交"/>
  	 </td>
  	 <td ><input name="cs" type="button" class="button" id="cs" value="取 消" onClick="move()"></td>
  </tr>
     </table>
     </form>
		
			
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
