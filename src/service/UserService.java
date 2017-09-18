package service;

import DAO.UserDao;
import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void save(){
        User user =new User();
        user.setName("asd");
        user.setPassword("asd1");
        user.setId(1);
        userDao.save(user);
    }

}