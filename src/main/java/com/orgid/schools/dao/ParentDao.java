package com.orgid.schools.dao;

import com.orgid.schools.vo.ParentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParentDao {
    List<ParentVo> getParent(ParentVo vo);
}
