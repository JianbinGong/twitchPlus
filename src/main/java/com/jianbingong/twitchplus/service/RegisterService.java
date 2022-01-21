package com.jianbingong.twitchplus.service;

import com.jianbingong.twitchplus.dao.RegisterDao;
import com.jianbingong.twitchplus.entity.db.User;
import com.jianbingong.twitchplus.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDao.register(user);
    }

}

