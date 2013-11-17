package com.wjrong.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wjrong.dao.PictureDao;
import com.wjrong.model.Pager;
import com.wjrong.model.PhotoFile;
import com.wjrong.model.Picture;
import com.wjrong.service.PictureService;
import com.wjrong.util.FileUpLoadUtil;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {

	private PictureDao pictureDao;
	
	public PictureDao getPictureDao() {
		return pictureDao;
	}
	@Resource
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	@Override
	public void add(Picture picture) {
		picture.setCreateDate(new Date());
		this.pictureDao.add(picture);
	}
	
	@Override
	public void add(Picture picture, PhotoFile photoFile, String uploadUrl,String uploadUrl2) {
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<photoFile.getPhoto().length; i++){
			String oldName = photoFile.getPhotoFileName()[i];
			String newName = FileUpLoadUtil.updateFileName(oldName);
			FileUpLoadUtil.UploadFile(uploadUrl + newName, photoFile.getPhoto()[i]);
			buffer.append(newName).append("?");
		}
		
		picture.setTpicture(uploadUrl2+buffer.substring(0, buffer.length()-1));
		picture.setCreateDate(new Date());
		this.pictureDao.add(picture);
	}
	
	@Override
	public void addimg(PhotoFile photoFile, String uploadUrl) {
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<photoFile.getPhoto().length; i++){
			String oldName = photoFile.getPhotoFileName()[i];
			String newName = FileUpLoadUtil.updateFileName(oldName);
			FileUpLoadUtil.UploadFile(uploadUrl + newName, photoFile.getPhoto()[i]);
			buffer.append(newName).append("?");
		}

	}

	@Override
	public void update(Picture picture) {
		this.pictureDao.update(picture);
	}
	
	@Override
	public void update(Picture picture, PhotoFile photoFile, String uploadUrl,String uploadUrl2) {
		StringBuffer buffer = new StringBuffer();		
		for(int i=0; i<photoFile.getPhoto().length; i++){
			String oldName = photoFile.getPhotoFileName()[i];
			String newName = FileUpLoadUtil.updateFileName(oldName);
			FileUpLoadUtil.UploadFile(uploadUrl + newName, photoFile.getPhoto()[i]);
			buffer.append(newName).append("?");
		}
		picture.setTpicture(uploadUrl2+buffer.substring(0, buffer.length()-1));
		
		this.pictureDao.update(picture);
	}
	
	@Override
	public void delete(int id) {
		
		this.pictureDao.delete(id);
	}

	@Override
	public Picture load(int id) {
		return this.pictureDao.load(id);
	}
	
	@Override
	public Pager<Picture> findPicture() {
		//return this.articleDao.find("select Article,c.name from Article as a,category as c where c.categoryid = a.categoryid order by a.createDate desc");
		//return this.articleDao.find("from Article a left join a.categoryid c where a.categoryid=1");	//from Student s left join s.course c where s.sname='李晓梅'";
		//return this.articleDao.find("from Article a,Category c where a.categoryid=1 order by a.createDate desc");
		return this.pictureDao.find("from Picture n order by n.createDate desc");
		//return this.articleDao.find("select new con.wjrong.model.Artcatall(a.Title,c.Categoryname,a.Id,a.Author) from Article a,Category c where c.Categoryidid=a.Categoryidid");
	}
	
	@Override
	public Pager<Picture> findPicture(String categoryid) {
		return this.pictureDao.find("from Picture n where n.categoryid=" + categoryid + " order by n.createDate desc");
	}
	
	@Override
	public void deleteGroupPicture(Object[] ids) {
		String hql = "delete Picture n where n.id=?";
		
		for(Object obj: ids){
			this.pictureDao.executeByHql(hql, obj);
		}
	}
	
	@Override
	public Picture updateCheckPicture(int id) {
		Picture n = this.load(id);
		if(n != null){
			int clickRate = n.getClickRate();
			clickRate += 1;
			n.setClickRate(clickRate);
			this.pictureDao.update(n);
		}
		return n;
	}
	
	@Override
	public List<Picture> queryNumber(int number) {
		List<Picture> listPicture = new ArrayList<Picture>();
		String sql = "select id,title " +
				"from t_picture t ORDER BY t.create_date DESC LIMIT " + number ;
		
		List<Object> list = this.pictureDao.querySQL(sql);
		
		for (Iterator<Object> iter=list.iterator(); iter.hasNext();) {
			Object[] obj = (Object[])iter.next();
			Picture n = new Picture();
			n.setId((Integer) obj[0]);
			n.setTitle((String) obj[1]);
			listPicture.add(n);
		}
		return listPicture;
	}
}
