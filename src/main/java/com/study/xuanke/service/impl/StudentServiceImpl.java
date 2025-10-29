package com.study.xuanke.service.impl;

import com.study.xuanke.dao.StudentDao;
import com.study.xuanke.model.Course;
import com.study.xuanke.model.SelectedCourse;
import com.study.xuanke.model.Student;
import com.study.xuanke.model.Teacher;
import com.study.xuanke.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    //  注入dao
    @Autowired
    private StudentDao studentDao;
//    学生登录
    @Override
    public Map<String,Object> getStudent(Student student) {
        System.out.println("走到StudentService");
        Map<String,Object> ret = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        params.put("studentId",student.getStudentId());
        params.put("studentPassword",student.getStudentPassword());
        Student stu = studentDao.getStudent(params);
        if (stu == null){
            stu = new Student();
            ret.put("code",-1);
            ret.put("msg","用户或密码不正确");
            return ret;
        }
        ret.put("code",3);
        ret.put("msg","登录成功");
        ret.put("studentId",student.getStudentId());
        ret.put("studentPassword",student.getStudentPassword());
        ret.put("student",stu);

        return ret;
    }
    @Override
    public List<SelectedCourse> queryScoreList(Map<String, Object> param) {
        return studentDao.queryScoreList(param);
    }

    @Override
    public List<SelectedCourse> queryScoreByKey(Map<String, Object> param) {
        return studentDao.queryScoreByKey(param);
    }

    @Override
    public Integer queryScoreCount(Map<String, Object> param) {
        return studentDao.queryScoreCount(param);
    }
//    @Override
//    public Integer update(Student student) {
//        return studentDao.update(student);
//    }
    /**
     * 修改密码
     * @param studentId
     * @param oldpassword
     * @param newpassword
     * @return
     */
    @Override
    public  Map<String,Object> updatePassword(int studentId, String oldpassword, String newpassword){
        Map<String,Object> ret = new HashMap<String,Object>();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("studentId", studentId);
        params.put("studentPassword", oldpassword);
        com.study.xuanke.model.Student u = studentDao.getStudent(params);
        if (u!=null){
            if(!oldpassword.equals(newpassword)){
            int i = studentDao.updatePassword(studentId, newpassword);
            if(i>0){
                ret.put("code","1");
                ret.put("msg","修改成功");
            }else {
                ret.put("code","0");
                ret.put("msg","修改失败");
            }
        }else {
                ret.put("code","-2");
                ret.put("msg","新密码不得与旧密码相同");
        }}
        else{
            ret.put("code","-1");
            ret.put("msg","旧密码错误");
        }
        return ret;
    }


    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public List<Student> findByKey(String key) {
        return studentDao.findByKey(key);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student)>0?true:false;
    }

    @Override
    public Student getById(int studentId) {
        return studentDao.getById(studentId);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student)>0?true:false;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        return studentDao.deleteStudent(studentId)>0?true:false;
    }

    @Override
    public void batchDeletes(List delList) {
        studentDao.batchDeletes(delList);
    }

    @Override
    public List<Student> findStudentInfo(Integer studentId) {
        return studentDao.findStudentInfo(studentId);
    }
}

