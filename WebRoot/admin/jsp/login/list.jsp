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
    
    <script src="<%=path %>/js/jquery-1.7.1.js" type="text/javascript"></script>
	<link href="<%=basePath %>admin/images/skin.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<script type="text/javascript">
    function LoginDelete(){
	return window.confirm("你确认要删除吗?");
	}
  	</script> 
	
	<style type="text/css">
		.tableClass{border:0; margin:0; border-collapse:collapse;} 
		.tableClass td{border:1px solid #000;word-wrap: break-word;}
		.red{color:red; font-weight：800;}
	</style>
	
  </head>
  
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="<%=basePath %>admin/images/mail_leftbg.gif"><img src="<%=basePath %>admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=basePath %>admin/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">账号列表</div></td>
	      </tr>
	    </table></td>
	    <td width="16" valign="top" background="<%=basePath %>admin/images/mail_rightbg.gif"><img src="<%=basePath %>admin/images/nav-right-bg.gif" width="16" height="29" /></td>
	  </tr>
	  <tr>
	    <td valign="middle" background="<%=basePath %>admin/images/mail_leftbg.gif">&nbsp;</td>
	    <td valign="top" bgcolor="#F7F8F9">
	    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
			
			<center>
				<table class="tableClass" cellspacing="0" align="center" width="700">
				   <tr>
				    	<td bgcolor="#EEEEEE" align="center">用户</td>
				    	<td bgcolor="#EEEEEE" align="center">用户类型</td>
				    	<td bgcolor="#EEEEEE" align="center">创建时间</td>
				    	<s:if test="#session.userlogin.type == 0">
				    		<td bgcolor="#EEEEEE" align="center">删除</td>
				    	</s:if>
				    </tr>
				    
				  <s:iterator value="#pager.datas">
				  	<tr>
				  		<td align="center">
				  			<s:if test="type == 0">
				  				<span class="red">${username}</span>
				  			</s:if>
				  			<s:else>
				  				${username}
				  			</s:else>
				  		</td>
				  		<td align="center">
				  			<s:if test="type == 0">
				  				<span class="red">超级用户</span>
				  			</s:if>
				  			<s:else>
				  				普通用户
				  			</s:else>
				  		</td>
				  		<td align="center">
				  			<s:date name="createDate" format="yyyy-MM-dd hh:mm:ss"/>
				  		</td>
				  		
				  		<s:if test="#session.userlogin.type == 0">
					  		<td align="center">
					  			<s:if test="type == 0">
					  				<span class="red">不可删除</span>
					  			</s:if>
					  			<s:else>
					  				<a href="login_delete.action?id=${id}">删除</a>
					  			</s:else>
					  		</td>
				  		</s:if>
				  	</tr>
				  </s:iterator>
			    </table>
    		</center>
    
			<table align="center" width="700">
				<tr>
					<td>
						<jsp:include page="/pager/pager.jsp">
							<jsp:param value="login_list.action" name="url" />
							<jsp:param value="${pager.totalRecord}" name="items" />
							<jsp:param value="${pager.pageSize}" name="pageSize" />
							<jsp:param value="id" name="params" /> 
						</jsp:include>
					</td>
				</tr>
			</table>	
			
		</td>
		</tr>
	    </table></td>
	    
	    
	    <td background="<%=basePath %>admin/images/mail_rightbg.gif">&nbsp;</td>
	  </tr>
	  <tr>
	    <td valign="bottom" background="<%=basePath %>admin/images/mail_leftbg.gif"><img src="<%=basePath %>admin/images/buttom_left2.gif" width="17" height="17" /></td>
	    <td background="<%=basePath %>admin/images/buttom_bgs.gif"><img src="<%=basePath %>admin/images/buttom_bgs.gif" width="17" height="17"></td>
	    <td valign="bottom" background="<%=basePath %>admin/images/mail_rightbg.gif"><img src="<%=basePath %>admin/images/buttom_right2.gif" width="16" height="17" /></td>
	  </tr>
	</table>
	</body>
</html>
