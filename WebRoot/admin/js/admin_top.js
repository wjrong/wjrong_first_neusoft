function loginOut(){
	if(window.confirm("是否退出用户？")){
		$.post("loginUser_logout.action",{flag:"loginOut"},function(data){
			if(data=="1"){
				if($.browser.msie){
					top.window.location.href="admin/login.jsp";
				}else if($.browser.mozilla){
					top.window.location.href="admin/login.jsp";
				}else{
					top.window.location.href="admin/login.jsp";
				}
			}else{
				alert("退出失败！");
			}
		},type="html");
	}
}

function showsubmenu(sid) {
	var whichEl = eval("submenu" + sid);
	var menuTitle = eval("menuTitle" + sid);
	if (whichEl.style.display == "none"){
		eval("submenu" + sid + ".style.display=\"\";");
	}else{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}

function showsubmenu(sid) {
	var whichEl = eval("submenu" + sid);
	var menuTitle = eval("menuTitle" + sid);
	if (whichEl.style.display == "none"){
		eval("submenu" + sid + ".style.display=\"\";");
	}else{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}

function logout(){
	if (confirm("您确定要退出控制面板吗？"))
	top.location = "out.asp";
	return false;
}