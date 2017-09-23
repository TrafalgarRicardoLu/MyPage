package DAO;

import Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user){
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
        return;
    }

    public List<User> allUser(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User");
        List<User> users = query.list();
        for(User user:users){
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getPassword());
        }
        return query.list();
    }

    public User searchUser(String userName){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where name = ?");
        query.setParameter(0,userName);
        return (User) query.uniqueResult();
    }

    public void deleteUser(String userName){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from User where name = ?");
        query.setParameter(0,userName);
        session.delete(query.uniqueResult());
        transaction.commit();
        session.close();
    }


    public void updateUser(String userName ,String password){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from User where name = ?");
        query.setParameter(0,password);
        User user = (User) query.uniqueResult();
        user.setPassword(password);
        session.update(user);
        transaction.commit();
        session.close();
    }


}
