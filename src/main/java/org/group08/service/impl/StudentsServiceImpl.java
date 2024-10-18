package org.group08.service.impl;

import org.group08.entity.Students;
import org.group08.mapper.StudentsMapper;
import org.group08.service.StudentsService;
import org.group08.util.RegEX;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {
    @Resource
    private StudentsMapper studentsMapper;

    @Override
    public Students loginStudents(String idOrEmail, String password) {
        Students stu = new Students();
        if (RegEX.isEmail(idOrEmail)) {
            stu.setEmail(idOrEmail);
        } else {
            stu.setId(idOrEmail);
        }
        return studentsMapper.getStudents(stu);
    }

    @Override
    public int checkEmail(String email) {
        return studentsMapper.emailCheck(email);
    }

    @Override
    public int saveStudent(Students student) {
        return studentsMapper.saveStudent(student);
    }
}
