package com.study.xuanke.service.impl;


import com.study.xuanke.dao.DepartmentDao;
import com.study.xuanke.model.Department;
import com.study.xuanke.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl  implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<Department> findByKey(String key) {
        return departmentDao.findByKey(key);
    }

    @Override
    public boolean addDepartment(Department department) {
        return departmentDao.addDepartment(department)>0?true:false;
    }

    @Override
    public Department getById(int departmentId) {
        return departmentDao.getById(departmentId);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentDao.updateDepartment(department)>0?true:false;
    }

    @Override
    public boolean deleteDepartment(int departmentId) {
        return departmentDao.deleteDepartment(departmentId)>0?true:false;
    }

    @Override
    public void batchDeletes(List delList) {
        departmentDao.batchDeletes(delList);
    }
}
