<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理页面</title>
	<meta http-equiv=Content-Type content=text/html;charset=utf-8>
	<meta http-equiv="refresh" content="60">
	<link href="admin/images/skin.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/admin_top.js"></script>
  </head>
  
	<body leftmargin="0" topmargin="0">
		<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
		  <tr>
		    <td width="61%" height="64"><img src="admin/images/logo.gif" width="262" height="64"></td>
		    <td width="39%" valign="top">
		    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			        <td width="74%" height="38" class="admin_txt">
			        	管理员：<b><font color="red" size="3"><s:property value="#session.userlogin.username"/></font></b>您好,感谢登陆使用！
			        </td>
			        <td width="22%">
			        	<a href="javascript:loginOut()" target="_self">
			        		<img src="admin/images/out.gif" alt="安全退出" width="46" height="20" border="0" ></a>
			        	</td>
			        <td width="4%">&nbsp;</td>
			      </tr>
			      <tr>
			        <td height="19" colspan="3">&nbsp;</td>
			        </tr>
		    	</table>
		    </td>
		  </tr>
		</table>
	</body>
</html>
