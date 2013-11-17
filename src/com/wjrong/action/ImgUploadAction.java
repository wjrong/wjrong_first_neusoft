package com.wjrong.action;

import java.io.File;
import java.util.Calendar;
import org.apache.struts2.ServletActionContext;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjrong.model.Picture;
import com.wjrong.model.PhotoFile;
import com.wjrong.service.PictureService;
import com.wjrong.util.ActionUtil;

/**
 * 图片(后台)
 * @author wjrong
 * @data 2013-10-20
 *
 */
@SuppressWarnings("serial")
@Controller("imgUploadAction")
@Scope("prototype")
public class ImgUploadAction extends ActionSupport implements ModelDriven<Picture> {
	private Picture picture;
	private PictureService pictureService;
	private Integer[] delid;	//一组id
	private PhotoFile photoFile;	//上传类
	private String photoNoDelete;	//从服务器传来判断是否删除了图片
	
	
	/**
	 *	添加图片
	 */
	public String addimg(){
		if(photoFile == null){
			this.pictureService.add(picture);
			ActionUtil.setURL("picture_list.action");
			return ActionUtil.REDIRECT;
		}
		Calendar calendar = Calendar.getInstance();
		String timestamp = calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH);
		
		String uploadUrl2="uploadFile/picture/" + "upload/" + timestamp+"/";
		String uploadUrl = ServletActionContext.getServletContext().getRealPath("/") + uploadUrl2;
		
		File fl=new File(uploadUrl);
		if(!fl.exists()){
			//如果没有目录就建目录
			fl.mkdirs();
		}
		this.pictureService.addimg(photoFile, uploadUrl);
		ActionUtil.setURL(null);
		return ActionUtil.REDIRECT;
	}

	
	@Override
	public Picture getModel() {
		if(picture == null) picture = new Picture();
		return picture;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public PictureService getPictureService() {
		return pictureService;
	}
	@Resource
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	public Integer[] getDelid() {
		return delid;
	}
	public void setDelid(Integer[] delid) {
		this.delid = delid;
	}
	public PhotoFile getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(PhotoFile photoFile) {
		this.photoFile = photoFile;
	}
	public String getPhotoNoDelete() {
		return photoNoDelete;
	}
	public void setPhotoNoDelete(String photoNoDelete) {
		this.photoNoDelete = photoNoDelete;
	}
}
