package com.study.xuanke.dao;

import com.study.xuanke.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    List<Department> findAll();

    List<Department> findByKey(String key);

    int addDepartment(Department department);

    Department getById(int  departmentId);

    int updateDepartment(Department department);

    // 逻辑删除
    int deleteDepartment(int departmentId);

    //真实删除一大堆
    void batchDeletes(List delList);

}
