package DAO;

import Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user){
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
        return;
    }

    public List<User> all(){
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


}
