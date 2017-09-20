package test;

import DAO.UserDao;
import Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class userOfUser {

    @Test
    public void test1(){
        ApplicationContext context = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        User user = new User();
        user.setId(1);
        user.setPassword("123");
        user.setName("hello spring");
        session.save(user);
        transaction.commit();
        session.close();


    }

    @Test
    public void test2(){

    }

}
