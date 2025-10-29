package com.study.xuanke.service;

import com.study.xuanke.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    List<Department> findByKey(String key);
    //是否删除成功，一个逻辑值
    boolean addDepartment(Department department);

    Department getById(int departmentId);

    boolean updateDepartment(Department department);

    // 逻辑删除
    boolean deleteDepartment(int departmentId);

    void batchDeletes(List delList);
}
