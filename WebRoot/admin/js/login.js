//刷新验证码
function refreshRand(){
	$("#randCode").hide();
	$("#randCode").attr("src","Rand?sc="+new Date().getTime());
	$("#randCode").fadeIn("slow");
}
//check用户名
function c_username(){
	var username=$("#username").val();
	var s_username=$("#s_username");
	if(username==""){
		s_username.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">用户名不能为空！</font>");
	}else{
//		s_username.html("<img src=\"./admin/images/right.png \" />");
		s_username.html("");
	}
}
//check密码
function c_password(){
	var password=$("#password").val();
	var s_password=$("#s_password");
	if(password==""){
		s_password.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">密码不能为空！</font>");
	}else{
//		s_password.html("<img src=\"./admin/images/right.png \" />");
		s_password.html("");
	}
}
//check验证码
function c_rand(){
	var rand=$("#rand").val();
	var s_rand=$("#s_rand");
	if(rand==""){
		s_rand.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">验证码不能为空！</font>");
	}
}
//登录
function loginOnClick(){
	var username=$("#username").val();
	var password=$("#password").val();
	var rand=$("#rand").val();
	var s_username=$("#s_username");
	var s_password=$("#s_password");
	var s_rand=$("#s_rand");
	s_rand.html("<img src=\"./admin/images/onLoad.gif \" />");
	s_rand.html("<img src=\"./admin/images/onLoad.gif \" />");
	$.post("loginUser_islogin.action",{"username":username,"password":password,rand:rand},function(data){
		// 返回1——帐号或密码错误，返回2——验证码错误，返回3——成功
		switch (data) {
		case "1":
			s_username.html("<img src=\"./admin/images/error.png \" />");
			s_password.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">用户名或密码错误！</font>");
			s_rand.html("<img src=\"./admin/images/right.png \" />");
			break;
		case "2":
			s_rand.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">验证码错误，请重新输入！</font>");
			refreshRand();
			break;
		case "3":
			s_username.html("<img src=\"./admin/images/right.png \" />");
			s_password.html("<img src=\"./admin/images/right.png \" />");
			s_rand.html("<img src=\"./admin/images/right.png \" />");
			if($.browser.msie){
				window.location.href="admin/jsp/index.jsp";
			}else if($.browser.mozilla){
				window.location.href="admin/jsp/index.jsp";
			}else{
				window.location.href="admin/jsp/index.jsp";
			}
			break;
		}
	},type="html");
}

//重置
function move(){
	$("#username").val("");
	$("#password").val("");
	$("#rand").val("");
	$("#s_username").html("");
	$("#s_password").html("");
	$("#s_rand").html("");
}