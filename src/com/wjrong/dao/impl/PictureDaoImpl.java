package com.wjrong.dao.impl;

import org.springframework.stereotype.Repository;

import com.wjrong.dao.PictureDao;
import com.wjrong.model.Picture;

@Repository("pictureDao")
public class PictureDaoImpl extends SuperDaoImpl<Picture> implements PictureDao {
}
