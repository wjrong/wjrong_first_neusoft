<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <script src="<%=basePath %>js/jquery.js" type="text/javascript"></script>
	<link href="<%=basePath %>admin/images/skin.css" rel="stylesheet" type="text/css" />
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
	
	<script type="text/javascript">
		function testDelete() {
			var flag = false;
			var de = document.getElementsByName("delid");
			for ( var i = 0; i < de.length; i++) {
				if (de[i].checked == true) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				alert("至少选择一个待删除记录");
				return false;
			}
			if (confirm("确定删除?")) {
				testForm.action = "article_checkboxDelete.action";
				testForm.submit();
			}
	
		}
	
		//多个删除
		$(document).ready(function(){
			// 全选        
			$("#allselect").click(function(){
				$(":checkbox").each(function(){
					$(this).attr("checked",true);
				});    
			});
			//反选
			$("#invert").click(function(){
				$(":checkbox").each(function(){
					if($(this).attr("checked")){
						$(this).attr("checked",false);
					}else{
						$(this).attr("checked",true);
					}
				});      
			});
			//取消
			$("#cancel").click(function(){
				$(":checkbox").each(function(){
					$(this).attr("checked",false);
				});      
			});
		});		
	</script>
  </head>
  
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="<%=basePath %>admin/images/mail_leftbg.gif"><img src="admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=basePath %>admin/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">职位空缺</div></td>
	      </tr>
	    </table></td>
	    <td width="16" valign="top" background="<%=basePath %>admin/images/mail_rightbg.gif"><img src="admin/images/nav-right-bg.gif" width="16" height="29" /></td>
	  </tr>
	  <tr>
	    <td valign="middle" background="<%=basePath %>admin/images/mail_leftbg.gif">&nbsp;</td>
	    <td valign="top" bgcolor="#F7F8F9">
	    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
			
			
		<form method="post" name="testForm"> 	
  	<table cellspacing="0" cellpadding="0" border="0" align="center">
  		<tr>
  			<td>&nbsp;</td>
  		</tr>
    	<tr>
        	<td height="20" colspan="7">
            	<span>
                	<input type="button" value="全选" id="allselect"/>
                	<input type="button" value="反选" id="invert" />
                    <input type="button" value="取消" id="cancel" />
                    <input type="submit" value="删除选中" onClick="testDelete()" />
                </span>
            </td>
        </tr>
        <tr>
        	<td colspan="7">
            	<table class="newfont03" cellspacing="1" align="center" cellpadding="4" border="0" bgcolor="#464646" width="850">
                	<tr>
                    	<td class="tablestyle_title" bgcolor="#EEEEEE" align="center" height="20" colspan="14">
                        	职位空缺
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#EEEEEE" align="center" width="5%">选择</td>
                        <td bgcolor="#EEEEEE" align="center" width="35%">文章标题</td>
                        <td bgcolor="#EEEEEE" align="center" width="10%">作者</td>
                        <td bgcolor="#EEEEEE" align="center" width="8%">分类栏目</td>
                        <td bgcolor="#EEEEEE" align="center" width="8%">推荐级别</td>
                        <td bgcolor="#EEEEEE" align="center" width="15%">发布时间</td>
                        <td bgcolor="#EEEEEE" align="center" width="10%">操作</td>
                    </tr>
                    
					<s:iterator value="#pages.datas">
						<tr align="center">
							<td bgcolor="#FFFFFF">
								<input type="checkbox" name="delid"  value="<s:property value="id" />"/>
	 						</td>
							<td bgcolor="#FFFFFF">
								<a href="article_check.action?id=${id}">${title}</a>
							</td>
							<td bgcolor="#FFFFFF">
								<p>${author}</p>
							</td>
							<td bgcolor="#FFFFFF">
								<p>${categoryid}</p>
							</td>
							<td bgcolor="#FFFFFF">
								<p>${ttop}</p>
							</td>
							<td bgcolor="#FFFFFF">
								<s:date name="createDate" format="yyyy-MM-dd hh:mm:ss"/>
							</td>
							<td bgcolor="#FFFFFF">
								<a href="article_updateInput.action?id=${id}">修改</a> |
								<a href="article_delete.action?id=${id}" onClick="if(confirm('您确认删除此文章【${title}】？'))return true;return false;" >删除</a>
							</td>
						</tr>
					</s:iterator>
                </table>
            </td>
        </tr>
  	</table>
  	<table width="800" align="center">
  		<tr>
  			<td align="center">
  				<jsp:include page="/pager/pager.jsp">
					<jsp:param value="article_listCid8.action" name="url" />
					<jsp:param value="${pages.totalRecord}" name="items" />
					<jsp:param value="${pages.pageSize}" name="pageSize" />
					<jsp:param value="id" name="params" /> 
				</jsp:include>
  			</td>
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
