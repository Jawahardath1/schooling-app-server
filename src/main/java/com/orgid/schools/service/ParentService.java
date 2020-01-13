package com.orgid.schools.service;

import com.orgid.schools.dao.ParentDao;
import com.orgid.schools.vo.ParentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParentService {

    @Autowired
    private ParentDao parentDao;

    public List<ParentVo> getParent(ParentVo vo) {
        return parentDao.getParent(vo);
    }
}
