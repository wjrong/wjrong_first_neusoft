<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script src="<%=basePath %>js/jquery-1.7.1.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    
    /**
     * 获取当前时间的不同格式
     */
     Date.prototype.format = function(format){ 
    	 var o = { 
    	 "M+" : this.getMonth()+1, //month 
    	 "d+" : this.getDate(), //day 
    	 "h+" : this.getHours(), //hour 
    	 "m+" : this.getMinutes(), //minute 
    	 "s+" : this.getSeconds(), //second 
    	 "q+" : Math.floor((this.getMonth()+3)/3), //quarter 
    	 "S" : this.getMilliseconds() //millisecond 
    	 }; 
    	 if(/(y+)/.test(format)) { 
    	 format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    	 } 
    	 for(var k in o) { 
    	 if(new RegExp("("+ k +")").test(format)) { 
    	 format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
    	 } 
    	 } 
    	 return format; 
    	 }; 

    
    
	
	$(function()
	{
		$("#button_show").click(function()
		{
			$.post("wap_Article_show.action",{id: $("#id").val()}, 
				function(returnedData, status)
			{
				var article = returnedData;
				
				var id = article.id;
				var title = article.title;
				var author = article.author;
				var categoryid = article.categoryid;
				var clickRate = article.clickRate;
				var createDate = article.createDate;
				var content = article.content;
				var tpicture = article.tpicture;
				var ttop = article.ttop;
				
				var html = "<table width='60%' border='1' align='center'><tr><th>id</th><th>title</th><th>author</th><th>categoryid</th><th>clickRate</th><th>createDate</th><th>content</th><th>tpicture</th><th>ttop</th><tr align='center'><td>" + id + "</td><td>" + title + "</td><td>" + author + "</td><td>" + categoryid + "</td><td>"+clickRate+"</td><td>"+createDate+"</td><td>"+content+"</td><td>"+tpicture+"</td><td>"+ttop+"</td></tr></table>";
		
				$("#article_list table:eq(0)").remove();
			
				$("#article_list").append(html);
				
			});			
		});
	});
	
	</script>
	
	<script type="text/javascript">
	
	$(function()
	{
		$("#button_list").click(function()
		{
			$.post("wap_Article_list.action",null, 
				function(returnedData, status)
			{
				var article = returnedData;
				$("#article_list").html("");
				$.each( article, function(index, content){  
				
				var id = content.id;
				var title = content.title;
				var author = content.author;
				var categoryid = content.categoryid;
				var clickRate = content.clickRate;
				var createDate = content.createDate;
				//var createDate=createDate2.format("yyyy年MM月dd日hh小时mm分ss秒");
				var content = content.content;
				var tpicture = content.tpicture;
				var ttop = content.ttop;
				
				var html = "<table width='60%' border='1' align='center'><tr><th>id</th><th>title</th><th>author</th><th>categoryid</th><th>clickRate</th><th>createDate</th><th>content</th><th>tpicture</th><th>ttop</th><tr align='center'><td>" + id + "</td><td>" + title + "</td><td>" + author + "</td><td>" + categoryid + "</td><td>"+clickRate+"</td><td>"+createDate+"</td><td>"+"content"+"</td><td>"+tpicture+"</td><td>"+ttop+"</td></tr></table>";
		
				
			
				$("#article_list").append(html);
				});
			});			
		});
	});
	
	</script>
	
	<script type="text/javascript">
	
	$(function()
	{
		$("#button_listcid").click(function()
		{
			 //var now = new Date();
		    //var nowStr = now.format("yyyy年MM月dd日hh小时mm分ss秒");
			//alert(nowStr);
			$.post("wap_Article_listcid.action",{categoryid: $("#categoryid").val()}, 
				function(returnedData, status)
			{
				var article = returnedData;
				$("#article_list").html("");
				$.each( article, function(index, content){  
				
				var id = content.id;
				var title = content.title;
				var author = content.author;
				var categoryid = content.categoryid;
				var clickRate = content.clickRate;
				var createDate = content.createDate;
				//var createDate=createDate2.format("yyyy年MM月dd日hh小时mm分ss秒");
				var content = content.content;
				var tpicture = content.tpicture;
				var ttop = content.ttop;
				
				var html = "<table width='60%' border='1' align='center'><tr><th>id</th><th>title</th><th>author</th><th>categoryid</th><th>clickRate</th><th>createDate</th><th>content</th><th>tpicture</th><th>ttop</th><tr align='center'><td>" + id + "</td><td>" + title + "</td><td>" + author + "</td><td>" + categoryid + "</td><td>"+clickRate+"</td><td>"+createDate+"</td><td>"+"content"+"</td><td>"+tpicture+"</td><td>"+ttop+"</td></tr></table>";
		
				
			
				$("#article_list").append(html);
				});
			});			
		});
	});
	
	</script>
	
    <title>显示调用数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1 align="center">首页</h1>
    <hr>
    <center>
   	用ID查： <span><input type="text" id="id"/></span>
   	查列表：<span><input type="text"/></span>
	查分类：<span><input type="text" id="categoryid"/></span>
	<hr>
    <span><input type="button" id="button_show" value="显示数据"></span>
    <span><input type="button" id="button_list" value="显示数据"></span>
    <span><input type="button" id="button_listcid" value="显示数据"></span>
    <div id="article_list"></div>
    </center>
  </body>
</html>
