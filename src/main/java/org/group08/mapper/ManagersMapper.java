package org.group08.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.group08.entity.Managers;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@Mapper
public interface ManagersMapper {
    /**
     * Login
     * @param manager manager account and password
     * @return manager info
     */
    Managers getManager(Managers manager);


    /**
     * Register
     * @param manager manager info
     * @return state
     */
    int saveManager(Managers manager);
}
