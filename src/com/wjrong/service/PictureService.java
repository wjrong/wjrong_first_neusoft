package com.wjrong.service;

import java.util.List;

import com.wjrong.model.Pager;
import com.wjrong.model.PhotoFile;
import com.wjrong.model.Picture;

/**
 * 图片的管理层
 * @author wjrong
 * @data 2013-10-20
 *
 */
public interface PictureService {
	/**
	 * 添加图片（不带上传图片）
	 * @param picture	图片对象
	 */
	public void add(Picture picture);
	
	/**
	 * 添加图片（带上传）
	 * @param picture 图片对象
	 * @param photoFile	上传的类
	 * @param uploadUrl	上传到的路径
	 */
	public void add(Picture picture, PhotoFile photoFile, String uploadUrl,String uploadUrl2);
	
	/**
	 * 添加图片（带上传）
	 * @param photoFile	上传的类
	 * @param uploadUrl	上传到的路径
	 */
	public void addimg(PhotoFile photoFile, String uploadUrl);
	
	/**
	 * 更新数据（不带上传图片）
	 * @param picture 图片对象
	 */
	public void update(Picture picture);
	
	/**
	 * 更新数据（带上传）
	 * @param picture 图片对象
	 * @param photoFile	上传的类
	 * @param uploadUrl	上传到的路径
	 */
	public void update(Picture picture, PhotoFile photoFile, String uploadUrl,String uploadUrl2);
	
	/**
	 * 删除某个图片
	 * @param id 图片id
	 */
	public void delete(int id);
	
	/**
	 * 删除一组图片
	 * @param ids  一组id
	 */
	public void deleteGroupPicture(Object[] ids);
	
	/**
	 * 查询某个图片信息
	 * @param id 图片id
	 * @return 返回查询出来的Picture对象
	 */
	public Picture load(int id);
	
	/**
	 * 分页查询
	 * @return 返回Pager<Picture>对象
	 */
	public Pager<Picture> findPicture();
	
	/**
	 * 查询某个图片信息（带添加点击率量）
	 * @param id 图片id
	 * @return 返回查询出来的Picture对象
	 */
	public Picture updateCheckPicture(int id);
	
	/**
	 * 查询前几条数据
	 * @param number 需要查询的数目
	 * @return	返回List<Picture>
	 */
	public List<Picture> queryNumber(int number);


	/**
	 * 分类分页查询
	 * @param categoryid 分类ID
	 * @return 返回Pager<Picture>对象
	 */
	Pager<Picture> findPicture(String categoryid);
}
