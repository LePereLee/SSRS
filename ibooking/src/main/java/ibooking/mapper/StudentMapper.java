package ibooking.mapper;

import ibooking.model.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<StudentDO> getStudents();

    List<StudentDO> getStudent(@Param("stuNum") String stuNum);

    int saveStudent(@Param("stu") StudentDO stu);

    int deleteStudent(@Param("stuNum") String stuNum);
}
