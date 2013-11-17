<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
  <head>
    <base href="<%=basePath%>">
    
    <script src="<%=path %>/js/jquery-1.7.1.js" type="text/javascript"></script>
    <script src="<%=basePath %>admin/jsp/picture/js/ArticleCheck.js" type="text/javascript"></script>
    <script src="<%=basePath %>admin/jsp/picture/js/ArticleFormCheck.js" type="text/javascript"></script>
    <script charset="utf-8" src="<%=basePath %>admin/editor/kindeditor.js"></script>
	<script charset="utf-8" src="<%=basePath %>admin/editor/lang/zh_CN.js"></script>
	
    <script type="text/javascript">
    var editor;
    KindEditor.ready(function(K) {
      editor=K.create('#content', {
              uploadJson : '<%=basePath%>imgUpload.action',
              fileManagerJson : '',
              allowFileManager : false
      });
   	});
    </script>
    <script type="text/javascript">
		function showFileUpload(){
			document.getElementById("button").style.display="none";
			document.getElementById("file").style.display="inline";
			document.getElementById("button1").style.display="inline";
			document.getElementById("button2").style.display="inline";
		}
		function hideFileUpload(){
			document.getElementById("button").style.display="inline";
			document.getElementById("file").style.display="none";
			document.getElementById("button1").style.display="none";
			document.getElementById("button2").style.display="none";
		}
	</script>
   
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
  </head>
  
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="admin/images/mail_leftbg.gif"><img src="<%=basePath %>admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=basePath %>admin/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">发布图片</div></td>
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
			
			
		<form method ="post" action="picture_add.action" enctype="multipart/form-data" onSubmit="return formcheck()">
  <table align="center" width="450" border=0>
  <tr>
  	<td>标题：</td>
  	<td colspan="1">
	  	<input type="text" name="title" id="ititle" size="30"
	  	 	onClick="a_ititle()" onBlur="c_ititle()" maxLength="225"/>
  	<span id="s_ititle" ></span>
  	</td>
  </tr>
  <tr>
  	<td>图片作者：</td>
  	<td colspan="1">
	  	<input type="text" name="author" id="ititle" size="30"/>
  	<span id="s_ititle" ></span>
  	</td>
  </tr>
  <tr> 
    <td>推荐级别：</td>
  	<td colspan="2">
 
            <select  name="ttop" id="ittop" >
              <option value="1" selected="selected">级别1</option>
              <option value="2">级别2</option>
              <option value="3">级别3</option>
              <option value="4">级别4</option>
              <option value="5">级别5</option>
              <option value="6">级别6</option>
              <option value="7">级别7</option>
              <option value="8">级别8</option>
              <option value="9">级别9</option>
              <option value="10">级别10</option>
            </select>
  	<span style=" font-size:14px; color:#C90 ; font-family:'微软雅黑'" >------级别越高文章排序越靠前!</span>
  	</td>
  </tr>
  <tr> 
    <td>分类栏目：</td>
  	<td colspan="2">
  	<select  name="categoryid" id="icategoryid" >
              <option value="1" selected="selected">校园环境</option>
              <option value="2">校园图片</option>
            </select>
  	<span style=" font-size:14px; color:#C90 ; font-family:'微软雅黑'" >------图片栏目分类!</span>
  	</td>
  </tr>
  
  <tr>
  	<td>图片：</td>
  		<td colspan="2">
  			<input type="button" id="button" onClick="showFileUpload()" value="插入图片"/>
  			<input type="file" name="photoFile.photo" id="file" size="30"
  				style="display:none;" onClick="a_introduceImage()" onBlur="c_introduceImage()" />
			<input type="button" id="button1" onClick="resetFile()" style="display:none;" value="取消"/>
			<input type="button" id="button2" onClick="hideFileUpload()" style="display:none;" value="不插入图片"/>
			<span id="s_file" ></span>
		</td>
  </tr>
   
  <tr>
  	<td><input type="submit" value="提交"/> <br></td>
  </tr>
     </table>
     </form>
		
			
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
