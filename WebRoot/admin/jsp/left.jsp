<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>管理页面</title>
	<script src="<%=basePath%>admin/js/prototype.lite.js" type="text/javascript"></script>
	<script src="<%=basePath%>admin/js/moo.fx.js" type="text/javascript"></script>
	<script src="<%=basePath%>admin/js/moo.fx.pack.js" type="text/javascript"></script>
	<style>
		body {
			font:12px Arial, Helvetica, sans-serif;
			color: #000;
			background-color: #EEF2FB;
			margin: 0px;
		}
		#container {
			width: 182px;
		}
		H1 {
			font-size: 12px;
			margin: 0px;
			width: 182px;
			cursor: pointer;
			height: 30px;
			line-height: 20px;	
		}
		H1 a {
			display: block;
			width: 182px;
			color: #000;
			height: 30px;
			text-decoration: none;
			moz-outline-style: none;
			background-image: url("<%=basePath%>admin/images/menu_bgs.gif");
			background-repeat: no-repeat;
			line-height: 30px;
			text-align: center;
			margin: 0px;
			padding: 0px;
		}
		.content{
			width: 182px;
			height: 26px;
			
		}
		.MM ul {
			list-style-type: none;
			margin: 0px;
			padding: 0px;
			display: block;
		}
		.MM li {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 26px;
			color: #333333;
			list-style-type: none;
			display: block;
			text-decoration: none;
			height: 26px;
			width: 182px;
			padding-left: 0px;
		}
		.MM {
			width: 182px;
			margin: 0px;
			padding: 0px;
			left: 0px;
			top: 0px;
			right: 0px;
			bottom: 0px;
			clip: rect(0px,0px,0px,0px);
		}
		.MM a:link {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 26px;
			color: #333333;
			background-image: url("<%=basePath%>admin/images/menu_bg1.gif");
			background-repeat: no-repeat;
			height: 26px;
			width: 182px;
			display: block;
			text-align: center;
			margin: 0px;
			padding: 0px;
			overflow: hidden;
			text-decoration: none;
		}
		.MM a:visited {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 26px;
			color: #333333;
			background-image: url("<%=basePath%>admin/images/menu_bg1.gif");
			background-repeat: no-repeat;
			display: block;
			text-align: center;
			margin: 0px;
			padding: 0px;
			height: 26px;
			width: 182px;
			text-decoration: none;
		}
		.MM a:active {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 26px;
			color: #333333;
			background-image: url("<%=basePath%>admin/images/menu_bg1.gif");
			background-repeat: no-repeat;
			height: 26px;
			width: 182px;
			display: block;
			text-align: center;
			margin: 0px;
			padding: 0px;
			overflow: hidden;
			text-decoration: none;
		}
		.MM a:hover {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			line-height: 26px;
			font-weight: bold;
			color: #006600;
			background-image: url("<%=basePath%>admin/images/menu_bg2.gif");
			background-repeat: no-repeat;
			text-align: center;
			display: block;
			margin: 0px;
			padding: 0px;
			height: 26px;
			width: 182px;
			text-decoration: none;
		}
	</style>
</head>

<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a href="javascript:void(0)">账号管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath %>admin/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="login_addInput.action" target="main">增加账号</a></li>
		  <li><a href="login_list.action" target="main">账号列表</a></li>
		  <li><a href="<%=basePath %>admin/jsp/login/updateInput.jsp" target="main">修改密码</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">全部文章</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath%>admin/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="article_addInput.action" target="main">发布文章</a></li>
          <li><a href="article_list.action" target="main">文章列表</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">新间动态</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath%>admin/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a href="article_addInput.action" target="main">发布新闻</a></li>
		  <li><a href="article_listCid.action?categoryid=1" target="main">综合新闻</a></li>
		  <li><a href="article_listCid.action?categoryid=2" target="main">图片联播</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">学生服务</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath %>admin/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="article_listCid.action?categoryid=3" target="main">校园服务</a></li>
		  <li><a href="article_listCid.action?categoryid=4" target="main">奖  学  金</a></li>
		  <li><a href="article_listCid.action?categoryid=5" target="main">就业服务</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">教职工</a></h1>
      <div class="content">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><img src="<%=basePath %>admin/images/menu_topline.gif" width="182" height="5" /></td>
            </tr>
          </table>
        <ul class="MM">
			<li><a href="article_addInput.action" target="main">发布文章</a></li>
			<li><a href="article_listCid.action?categoryid=6" target="main">媒体聚焦</a></li>
			<li><a href="article_listCid.action?categoryid=7" target="main">科研团队</a></li>
			<li><a href="article_listCid.action?categoryid=8" target="main">职位空缺</a></li>
        </ul>
      </div>
	  <h1 class="type"><a href="javascript:void(0)">商业伙伴</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath %>admin/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
	       <li><a href="article_addInput.action" target="main">发布文章</a></li>
           <li><a href="article_listCid.action?categoryid=9" target="main">校企合作</a></li>
           <li><a href="article_listCid.action?categoryid=10" target="main">科研成果</a></li>
        </ul>
      </div>
	  <h1 class="type"><a href="javascript:void(0)">学院介绍</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath %>admin/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
			<li><a href="article_addInput.action" target="main">发布文章</a></li>
			<li><a href="article_listCid.action?categoryid=11" target="main">集团快讯</a></li>
			<li><a href="article_listCid.action?categoryid=12" target="main">专业介绍</a></li>
        </ul>
      </div>
	  <h1 class="type"><a href="javascript:void(0)">图片管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="<%=basePath %>admin/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
			<li><a href="picture_addInput.action" target="main">添加图片</a></li>
			<li><a href="picture_showlist.action" target="main">浏览全部</a></li>
			<li><a href="picture_listCid.action?categoryid=1" target="main">校园环境</a></li>
			<li><a href="picture_listCid.action?categoryid=2" target="main">校园图片</a></li>
			<li><a href="picture_showlistCid.action?categoryid=1" target="main">浏览环境</a></li>
			<li><a href="picture_showlistCid.action?categoryid=2" target="main">浏览校园</a></li>
			<li><a href="picture_addInput.action" target="main">添加图片</a></li>
        </ul>
      </div>
      </div>
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
        </td>
  </tr>
</table>
</body>
</html>
