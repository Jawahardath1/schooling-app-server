package com.orgid.schools.service;

import com.orgid.schools.dao.ParentDao;
import com.orgid.schools.model.Parent;
import com.orgid.schools.repository.ParentRepository;
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

    @Autowired
    private ParentRepository parentRepository;

    public List<ParentVo> getParent(ParentVo vo) {
        return parentDao.getParent(vo);
    }

    public boolean existsByparentrid(String parentid) {
        return parentRepository.existsByparentid(parentid);
    }

    public Parent insertParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public int updateParent(ParentVo vo) {
        return parentDao.updateParent(vo);
    }
}
