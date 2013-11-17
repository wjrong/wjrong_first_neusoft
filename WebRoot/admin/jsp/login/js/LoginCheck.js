//刷新验证码
function refreshRand(){
	$("#randCode").hide();
	$("#randCode").attr("src","Rand?sc="+new Date().getTime());
	$("#randCode").fadeIn("slow");
}
//用户名提示
function a_username(){
	var username=$("#username").val();
	var s_username=$("#s_username");
	if(username==""){
		s_username.html("<img src=\"./admin/images/right.png \" />3-11位字符，支持字母、数字、符号、中文！");
	}else{
//		s_username.html("<img src=\"./admin/images/right.png \" />");
		s_username.html("");
		
	}
}
//check修改用户名
function q_username(){
	var username=$("#username").val();
	var s_username=$("#s_username");
	if(username==""){
		s_username.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">用户名不能为空！</font>");
	}
}
//check用户名
function c_username(){
	var a = document.getElementById('prohibit');
	var username=$("#username").val();
	var s_username=$("#s_username");
	if(username==""){
		s_username.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">用户名不能为空！</font>");
	}else{
		$.post("login_check.action",{"login.username":username},function(data){
			// 返回1——可以使用，返回3——已被注册
			if(data==3){
				s_username.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">用户名已被注册！</font>");
				a.disabled=true; //使用true或false，控制是否让按钮禁用
			}else{
				s_username.html("<img src=\"./admin/images/right.png \" />用户名可使用！");
				a.disabled=false; //使用true或false，控制是否让按钮禁用
			}
		},type="html");		
	}
}
//密码提示
function a_password(){
	var password=$("#password").val();
	var s_password=$("#s_password");
	if(password==""){
		s_password.html("<img src=\"./admin/images/right.png \" />5-11位字符，只能使用字母或数字！");
	}else{
//		s_password.html("<img src=\"./admin/images/right.png \" />");
		s_password.html("");
	}
}//check密码
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
//确定密码提示
function a_ConfirmPassword(){
	var ConfirmPassword=$("#ConfirmPassword").val();
	var s_ConfirmPassword=$("#s_ConfirmPassword");
	if(ConfirmPassword==""){
		s_ConfirmPassword.html("<img src=\"./admin/images/right.png \" />重复输入一次密码！");
	}else{
//		s_password.html("<img src=\"./admin/images/right.png \" />");
		s_ConfirmPassword.html("");
	}
}
//确定密码
function c_ConfirmPassword(){
	var ConfirmPassword=$("#ConfirmPassword").val();
	var s_ConfirmPassword=$("#s_ConfirmPassword");
	if(ConfirmPassword==""){
		s_ConfirmPassword.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">确定密码不能为空！</font>");
	}else{
//		s_password.html("<img src=\"./admin/images/right.png \" />");
		s_ConfirmPassword.html("");
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
//check修改
function updateInputOnClick(){
	
	var username=$("#username").val();
	var password=$("#password").val();
	var rand=$("#rand").val();
	var s_username=$("#s_username");
	var s_password=$("#s_password");
	var s_rand=$("#s_rand");
	
	s_rand.html("<img src=\"./admin/images/onLoad.gif \" />");
	s_rand.html("<img src=\"./admin/images/onLoad.gif \" />");
	$.post("login_updateInput.action",{"username":username,"password":password,rand:rand},function(data){
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
				window.location.href="admin/jsp/login/updatePassword.jsp";
			}else if($.browser.mozilla){
				window.location.href="admin/jsp/login/updatePassword.jsp";
			}else{
				window.location.href="admin/jsp/login/updatePassword.jsp";
			}
			break;
		}
	},type="html");
}

//重置
function move(){
	$("#username").val("");
	$("#password").val("");
	$("#ConfirmPassword").val("");
	$("#rand").val("");
	$("#s_username").html("");
	$("#s_password").html("");
	$("#s_ConfirmPassword").html("");
	$("#s_rand").html("");
}