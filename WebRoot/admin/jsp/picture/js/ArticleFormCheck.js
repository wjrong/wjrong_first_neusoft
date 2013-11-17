function formcheck(){
	flag=true;
	editor.sync();//文本编辑器
	var image=$("#image").val();
	var ititle=$("#ititle").val();
	var s_ititle=$("#s_ititle");
	var file=$("#file").val();
	var s_file=$("#s_file");
	
	var ext="gif,jpg,jpeg,png,bmp";
	var filePoint=file.lastIndexOf('.')+1;
	var fileExt=file.substring(filePoint).toLowerCase();
	//alert(content);
	//标题
	if(ititle==""){
		s_ititle.html("<img src=\"./admin/images/error.png \" /><font color=\"red\">标题不能为空！</font>");
		return false;
	}else{
		s_ititle.html("<img src=\"./admin/images/right.png \" />");
	} 
	//图片
	if(ext.indexOf(fileExt)==-1){
		s_file.html("<img src=\"./admin/images/error.png \" /><font color=\"red\" size=\"2\">图片格式只能为gif,jpg,jpeg,png,bmp</font>");
		return false;
	}else{
		s_file.html("<img src=\"./admin/images/right.png \" />");
	}

	return flag;
}
