<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>网站管理员登陆</title>
    <style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #1D3647;
}

</style>
<script language="JavaScript">
function correctPNG()
{
    var arVersion = navigator.appVersion.split("MSIE");
    var version = parseFloat(arVersion[1]);
    if ((version >= 5.5) && (document.body.filters)) 
    {
       for(var j=0; j<document.images.length; j++)
       {
          var img = document.images[j];
          var imgName = img.src.toUpperCase();
          if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
          {
             var imgID = (img.id) ? "id='" + img.id + "' " : "";
             var imgClass = (img.className) ? "class='" + img.className + "' " : "";
             var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' ";
             var imgStyle = "display:inline-block;" + img.style.cssText ;
             if (img.align == "left") imgStyle = "float:left;" + imgStyle;
             if (img.align == "right") imgStyle = "float:right;" + imgStyle;
             if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle;
             var strNewHTML = "<span " + imgID + imgClass + imgTitle
             + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
             + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader";
             + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>";
             img.outerHTML = strNewHTML;
             j = j-1;
          }
       }
    }    
}
window.attachEvent("onload", correctPNG);
</script>
    <script src="<%=basePath %>js/jquery-1.7.1.js" type="text/javascript"></script>
    <script src="<%=basePath %>admin/js/login.js" type="text/javascript"></script>
	
	<link href="<%=basePath %>admin/images/skin.css" rel="stylesheet" type="text/css">
  </head>
  
<body>
<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top"><table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>

        <td height="42" align="center"><span style=" height:35px; font-size:14px; color:red">为了给你一个漂亮的体验，请使用谷歌浏览器!</span></td>

      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="top"><img src="admin/images/logo.png" width="279" height="68"></td>
                </tr>
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>1- 学园信息推送发布建立的首选方案...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>2- 学园一站通的整合方式，方便管理使用...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>3- 强大的后台系统，管理内容易如反掌...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="30%" height="40"><img src="admin/images/icon-demo.gif" width="16" height="16"> 使用说明 </td>
                      <td width="35%"><a href="http://www.wjrong.com/" target="_blank" ><img src="admin/images/icon-login-seaver.gif" width="16" height="16">技术支持</a></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38"><span class="login_txt_bt">登陆后台管理</span></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2" align="middle">
                    <form name="myform" action="javascript:loginOnClick()" method="post">
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
                          <tr>
                            <td width="13%" height="38" class="top_hui_text"><span class="login_txt">管理员：&nbsp;&nbsp; </span></td>
                            <td height="38" colspan="2" class="top_hui_text"><input name="username" id="username" class="editbox4" value="" size="20" onblur="c_username()" maxLength="11">
                            <span id="s_username" class="login_txt"></span>
                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="top_hui_text"><span class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input class="editbox4" id="password" type="password" size="20" name="password" onblur="c_password()" maxLength="11">
                              <!--<img src="admin/images/luck.gif" width="19" height="18"> -->
                              <span id="s_password" class="login_txt"></span>
                              </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" ><span class="login_txt">验证码：</span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input class=wenbenkuang name=rand id=rand type=text value="" maxLength=4 size=10 onblur="c_rand()">
                            <img src="Rand" id="randCode" title="看不清楚？请点击这里！" onclick="refreshRand()"/>
                            <span id="s_rand" class="login_txt"></span>
                            </td>
                          </tr>
                          <tr>
                            <td height="35" >&nbsp;</td>
                            <td width="20%" height="35" ><input name="login" type="submit" class="button" id="login" value="登 陆" > </td>
                            <td width="67%" class="top_hui_text"><input name="cs" type="button" class="button" id="cs" value="取 消" onClick="move()"></td>
                          </tr>
                        </table>
                        <br>
                    </form></td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="admin/images/login-wel.gif" width="242" height="133"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td height="35px" align="center"><span class="login-buttom-txt" style=" height:35px; font-size:14px;">技术支持：<a href="http://www.wjrong.com/" target="_blank" style=" font-size:14px; color:#C90 ; font-family:'微软雅黑' ">wjrong</a>&nbsp;&nbsp;&nbsp;CopyRight &copy; 2013 南海东软学院</span></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
