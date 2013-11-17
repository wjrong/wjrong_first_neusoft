//check标题
function c_ititle(){
	var ititle=$("#ititle").val();
	var s_ititle=$("#s_ititle");
	if(ititle==""){
		s_ititle.html("<img src=\"admin/images/error.png \" /><font color=\"red\">标题不能为空！</font>");
	
	}else{
		s_ititle.html("<img src=\"admin/images/right.png \" />");
		
	}
}

//check图片
function c_introduceImage(){
	var file=$("#file").val();
	var s_file=$("#s_file");
	
	var ext="gif,jpg,jpeg,png,bmp";
	var filePoint=file.lastIndexOf('.')+1;
	var fileExt=file.substring(filePoint).toLowerCase();
	
	if(ext.indexOf(fileExt)==-1){
		s_file.html("<img src=\"./admin/images/error.png \" /><font color=\"red\" size=\"2\">图片格式只能为gif,jpg,jpeg,png,bmp</font>");
	}else{
		s_file.html("<img src=\"./admin/images/right.png \" />");
	}
}

//清除文体域
function resetFile(){
	var fileup = document.getElementById("file");
	fileup.outerHTML = fileup.outerHTML;
}
