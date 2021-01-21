package com.sokkheang.huo.common.api.common.repository;

import org.apache.ibatis.annotations.Mapper;

import com.sokkheang.huo.common.api.common.model.Image;
import com.sokkheang.huo.common.utils.Paging;

import java.util.List;

@Mapper
public interface ImageRepository {

    public List<Image> findAll(Paging paging);

    public Image findById(Integer id);

    public boolean insertImage(Image image);

    public boolean updateImage(Image image);

    public boolean updateImageStatusCode(String statuscode);
    
    public int countImage(String statuscode);
}
