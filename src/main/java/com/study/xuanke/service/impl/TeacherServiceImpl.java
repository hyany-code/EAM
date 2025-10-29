package com.study.xuanke.service.impl;
import com.study.xuanke.model.Teacher;
import com.study.xuanke.dao.TeacherDao;
import com.study.xuanke.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;


import com.study.xuanke.model.SelectedCourse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    //  注入dao
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Map<String,Object> getTeacher(Teacher teacher) {
        System.out.println("走到TeacherService：getTeacher");
        Map<String,Object> ret = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        params.put("teacherId",teacher.getTeacherId());
        params.put("teacherPassword",teacher.getTeacherPassword());
        Teacher tea = teacherDao.getTeacher(params);
        if (tea == null){
            tea = new Teacher();
            ret.put("code",-1);
            ret.put("msg","用户或密码不正确");
//            ret.put("teacher",tea);
            return ret;
        }
        ret.put("code",3);
        ret.put("msg","登录成功");
        ret.put("teacherId",teacher.getTeacherId());
        ret.put("teacherPassword",teacher.getTeacherPassword());
        ret.put("teacher",tea);

        return ret;
    }

    //    查询所有选课学生信息
    @Override
    public List<SelectedCourse> queryStudentInfoList(Map<String, Object> param) {
        System.out.println("走到teacherService：queryStudentInfoList");
        return teacherDao.queryStudentInfoList(param);
    }
    //    关键字查询选课学生信息
    @Override
    public List<SelectedCourse> queryStudentInfoByKey(Map<String, Object> param) {
        return teacherDao.queryStudentInfoByKey(param);
    }
    //    符合条件的学生信息总条数
    @Override
    public Integer queryStudentInfoCount(Map<String, Object> param) {
        return teacherDao.queryStudentInfoCount(param);
    }

    //    查询所有成绩
    @Override
    public List<SelectedCourse> queryScoreList(Map<String, Object> param) {
        return teacherDao.queryScoreList(param);
    }
    //    关键字查询成绩
    @Override
    public List<SelectedCourse> queryScoreByKey(Map<String, Object> param) {
        return teacherDao.queryScoreByKey(param);
    }

    //    符合条件的成绩总条数
    @Override
    public Integer queryScoreCount(Map<String, Object> param) {
        return teacherDao.queryScoreCount(param);
    }

    @Override
    public SelectedCourse getByOptionId(Integer optionId) {
        return teacherDao.getByOptionId(optionId);
    }
    @Override
    public List<SelectedCourse> getByCourseId(Map<String, Object> param) {
        return teacherDao.getByCourseId(param);
    }
    @Override
    public List<SelectedCourse> export(Map<String, Object> param) {
        return teacherDao.export(param);
    }
    @Override
    public List<SelectedCourse> exportClassInfo(Map<String, Object> param) {
        return teacherDao.exportClassInfo(param);
    }

    //    添加、修改成绩
    @Override
    public void updateScore(SelectedCourse selectedCourse){
        float score = selectedCourse.getScore();
        float gpa;
        if(score>=90 && score<=100)
            gpa = (float)4.0;
        else if(score>=85 && score<=89)
            gpa = (float)3.7;
        else if(score>=80 && score <=84)
            gpa = (float)3.3;
        else if(score>=76 && score<=79)
            gpa = (float)3.0;
        else if(score>=73 && score<=75)
            gpa = (float)2.7;
        else if(score>=70 && score<=72)
            gpa = (float)2.3;
        else if(score>=66 && score<=69)
            gpa = (float)2.0;
        else if(score>=63 && score<=65)
            gpa = (float)1.7;
        else if(score>=61 && score<=62)
            gpa = (float)1.3;
        else if(score==60)
            gpa = (float)1.0;
        else
            gpa = 0;
        selectedCourse.setGpa(gpa);
        teacherDao.updateScore(selectedCourse);
    }
    // 逻辑删除
    @Override
    public boolean deleteScore(Integer optionId) {
        return teacherDao.deleteScore(optionId) > 0 ? true:false;
    }
    //    批量删除
    @Override
    public void batchDeletesScore(List delList) {
        teacherDao.batchDeletesScore(delList);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public List<Teacher> findByKey(String key) {
        return teacherDao.findByKey(key);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher)>0?true:false;
    }

    @Override
    public Teacher getById(int teacherId) {
        return teacherDao.getById(teacherId);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher)>0?true:false;
    }

    @Override
    public boolean deleteTeacher(int teacherId) {
        return teacherDao.deleteTeacher(teacherId)>0?true:false;
    }

    @Override
    public List<Teacher> getTeachersByDepartmentId(int departmentId) {
        return teacherDao.getTeachersByDepartmentId(departmentId);
    }

    /**
     * 修改密码
     * @param teacherId
     * @param oldpassword
     * @param newpassword
     * @return
     */
    @Override
    public  Map<String,Object> updatePassword(int teacherId, String oldpassword, String newpassword){
        Map<String,Object> ret = new HashMap<String,Object>();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("teacherId", teacherId);
        params.put("teacherPassword", oldpassword);
        com.study.xuanke.model.Teacher u = teacherDao.getTeacher(params);
        if (u!=null){
            if (!oldpassword.equals(newpassword)) {
                int i = teacherDao.updatePassword(teacherId, newpassword);
                if (i > 0) {                      //行数大于0
                    ret.put("code", "1");
                    ret.put("msg", "修改成功");
                } else {
                    ret.put("code", "0");
                    ret.put("msg", "修改失败");
                }
            } else {
                ret.put("code","-2");
                ret.put("msg","新密码不得与旧密码相同");
            }
        } else{
            ret.put("code", "-1");
            ret.put("msg", "旧密码错误");
        }
        return ret;
    }
    @Override
    public List<Teacher> findTeacherInfo(Integer teacherId) {
        return teacherDao.findTeacherInfo(teacherId);
    }

    @Override
    public List<Teacher> checkEmail(Map<String, Object> param) {
        return teacherDao.checkEmail(param);
    }
}
