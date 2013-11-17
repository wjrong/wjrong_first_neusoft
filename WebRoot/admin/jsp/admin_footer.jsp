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
    
    <title>footer页面</title>


	<meta http-equiv=Content-Type content=text/html;charset=utf-8>
	<meta http-equiv="refresh" content="60">
	<link href="admin/images/skin.css" rel="stylesheet" type="text/css">

  </head>
  
	<body leftmargin="0" footermargin="0">
		<table width="100%" height="40" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
		  <tr>
		    <td height="40"><table width="100%" height="40" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
		      <tr>
		        <td align="center" ><span class="login-buttom-txt" style=" font-size:14px;">技术支持：<a href="http://www.wjrong.com/" target="_blank" style=" font-size:14px; color:#C90 ; font-family:'微软雅黑' ">wjrong</a>&nbsp;&nbsp;&nbsp;CopyRight &copy; 2013 南海东软学院</span></td>
		      </tr>
		    </table></td>
		  </tr>
		</table>
	</body>
</html>