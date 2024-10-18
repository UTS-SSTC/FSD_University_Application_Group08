package org.group08.service;


import org.group08.entity.Managers;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
public interface ManagersService {
    Managers loginManager(String idOrEmail, String password);

    int saveManager(Managers manager);
}
