package org.group08.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.group08.entity.Students;

import java.util.List;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@Mapper
public interface StudentsMapper {
    /**
     * Login
     * @param student student account and password
     * @return student info
     */
    Students getStudents(Students student);

    /**
     * Check whether it has been registered
     * @param email student email
     * @return if registered
     */
    int emailCheck(String email);


    /**
     * Register
     * @param student student info
     * @return state
     */
    int saveStudent(Students student);

    /**
     * show students
     * @return all students
     */
    List<Students> getAllStudents();
}
