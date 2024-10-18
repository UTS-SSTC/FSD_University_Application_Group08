package org.group08.service.impl;

import org.group08.entity.Managers;
import org.group08.mapper.ManagersMapper;
import org.group08.service.ManagersService;
import org.group08.util.RegEX;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@Service
public class ManagersServiceImpl implements ManagersService {
    @Resource
    private ManagersMapper managersMapper;

    @Override
    public Managers loginManager(String idOrEmail, String password) {
        Managers man = new Managers();
        if (RegEX.isEmail(idOrEmail)) {
            man.setEmail(idOrEmail);
        } else {
            man.setId(idOrEmail);
        }
        return managersMapper.getManager(man);
    }

    @Override
    public int saveManager(Managers manager) {
        return managersMapper.saveManager(manager);
    }
}
