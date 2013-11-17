<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理中心</title>
    <meta http-equiv=Content-Type content=text/html;charset=utf-8>
  </head>
	<frameset rows="64,*,45"  frameborder="NO" border="0" framespacing="0">
		<frame src="<%=basePath %>admin/jsp/admin_top.jsp" noresize="noresize" frameborder="no" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
	  	
	  	<frameset cols="200,*" id="frame">
			<frame src="<%=basePath %>admin/jsp/left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
			<frame src="<%=basePath %>admin/jsp/right.jsp" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />
	  	</frameset>
	  	
	  	<frame src="<%=basePath %>admin/jsp/admin_footer.jsp" noresize="noresize" frameborder="no" name="footerFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
 	</frameset>

</html>
