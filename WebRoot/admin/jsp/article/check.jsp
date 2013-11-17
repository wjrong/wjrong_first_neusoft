<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
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
	        <td height="31"><div class="titlebt">文章显示</div></td>
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
			
			
		<s:iterator value="article">
		<table align="center" width="200" border=1>

		 	<tr>
		 	
  				<td align="center">
   					<a href="article_updateInput.action?id=${id}">修改</a>
    			</td>
    			<td align="center">
    				<a href="article_delete.action?id=${id}" 
    				onClick="if(confirm('您确认删除此文章【${title}】？'))return true;return false;" >删除</a>
    			</td>
  			</tr>
		</table>	
		<br/>
		<br/>	
		<table align="center" width="500" border=0>  
  			<tr>
  				<td align="center"><h3>${title}</h3></td>
  			</tr>
  			<tr>
  				<td align="center">
  					<p>
  						发布时间：<s:date name="createDate" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;&nbsp;作者：${author}&nbsp;&nbsp;点击量：${clickRate}
  					</p>
  				</td>
  			</tr>
  			<tr>
  				<td><hr/></td>
  			</tr>
  			<tr>
  				<td>${intro }</td>
  			</tr>
  			<tr>
  				<td><hr/></td>
  			</tr>
  			<tr>
  				<s:if test="tpicture==null">
  					<td>${content}</td>
  				</s:if>
  				<s:else>
  					<td><img src="<%=basePath%>${tpicture}" width="250" style="float: left;" />${content}</td>
  				</s:else>
  			</tr>
    
    		
    	</table>
		</s:iterator>
		
			
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
