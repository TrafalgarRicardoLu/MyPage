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

    public void saveUser(User user){ userDao.saveUser(user); }

    public List<User> allUser(){
        return userDao.allUser();
    }

    public User searchUser(String userName){ return userDao.searchUser(userName);}

    public void deleteUser(String userName){ userDao.deleteUser(userName);}

    public void updateUser(String userName,String password){userDao.updateUser(userName,password);}
}
