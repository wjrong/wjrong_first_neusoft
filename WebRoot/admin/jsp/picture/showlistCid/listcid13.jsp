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
	
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #EEF2FB;
	}
	
	#bo{ margin:auto; width:1000px ; height: 400px}
		#bo #kuang{
				float:left; 
				margin:20px 10px;		
				width:175px;
				height:150px;
				box-shadow:2px 2px 2px gray;
				position:relative;
				}
		#bo input{ position:absolute; left:0px ; top:0px ; width:15px ; height:15px;}
		#bo img { background-size:cover; background-repeat:no-repeat}
		#btn2{ width:175px; position:absolute; left:0px ; top:150px}
		#btn2 div{ float:left; width:40%; height:20px; text-align:center; border:#CCC  1px solid; margin:5px ; padding:2px;
		font-family:"微软雅黑"; font-size:14px; color:gray;
	}
	
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
				testForm.action = "picture_checkboxDelete.action";
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
		
		
		 function a1(test){
			 document.getElementById(test).style.backgroundColor="black";
			 }
		 function a2(test){
			 document.getElementById(test).style.backgroundColor="gray";
			 }

	</script>
  </head>
  
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="<%=basePath %>admin/images/mail_leftbg.gif"><img src="admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=basePath %>admin/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">校园环境</div></td>
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
</table>

<form method="post" name="testForm">
<div id="bo">
<s:iterator value="#pages.datas">
	<div id="kuang">
		<input type="checkbox" name="delid" value="<s:property value="id" />">
		<a href="picture_check.action?id=${id}"><img width='100%' height='100%' src="<%=basePath%>${tpicture}" ></a>
		<div id="btn2">
            <div onmousemove="a1(this.id)" onmouseout="a2(this.id)" ><a  href="picture_updateInput.action?id=${id}">修改</a></div>
            <div onmousemove="a1(this.id)" onmouseout="a2(this.id)" ><a  href="picture_delete.action?id=${id}" onClick="if(confirm('您确认删除此图片【${title}】？'))return true;return false;" >删除</a></div>
        </div>

	</div>
</s:iterator>
</div>

  	<table width="800" align="center">
  		<tr>
  			<td align="center">
  				<jsp:include page="/pager/pager.jsp">
					<jsp:param value="picture_showlist.action" name="url" />
					<jsp:param value="${pages.totalRecord}" name="items" />
					<jsp:param value="${pages.pageSize}" name="pageSize" />
					<jsp:param value="id" name="params" />
					<jsp:param value="1" name="categoryid" />
				</jsp:include>
  			</td>
  		</tr>
  	</table>
  	
</form>  
 	</td>
 </tr> 
</table>
			</td>
			<td background="admin/images/mail_rightbg.gif">&nbsp;</td>
		</tr>
	</table>
</body>
</html>
