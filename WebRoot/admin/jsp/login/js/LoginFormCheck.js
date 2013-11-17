function formcheck(){
	var username=$("#username").val();
	var s_username=$("#s_username");
	var password=$("#password").val();
	var s_password=$("#s_password");
	var ConfirmPassword=$("#ConfirmPassword").val();
	var s_ConfirmPassword=$("#s_ConfirmPassword");
	if(username==""){
		s_username.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">用户名不能为空！</font>");
		return false;
	}else if(password==""){
		s_password.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">密码不能为空！</font>");
		return false;
	}else if(ConfirmPassword==""){
		s_ConfirmPassword.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">确定密码不能为空！</font>");
		return false;
	}else if(username.length<3){
		s_username.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">用户名3-11位！</font>");
		return false;
	}else if(password.length<5){
		s_password.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">密码5-11位！</font>");
		return false;
	}else if(ConfirmPassword!==password){
		s_ConfirmPassword.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">两次输入密码不同！</font>");
		return false;
	}
}