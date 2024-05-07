package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.StudentMapper;
import com.huawei.ibooking.model.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao {
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDO> getStudents() {
        return studentMapper.getStudents();
    }

    public List<StudentDO> getStudent(final String stuNum) {
        return studentMapper.getStudent(stuNum);
    }

    public boolean saveStudent(final StudentDO stu) {
        return studentMapper.saveStudent(stu) > 0;
    }

    public boolean deleteStudent(final String stuNum) {
        return studentMapper.deleteStudent(stuNum) > 0;
    }
}
