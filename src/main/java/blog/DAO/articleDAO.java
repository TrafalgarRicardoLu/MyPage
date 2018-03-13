package blog.DAO;


import Utils.ConfigHelper;
import blog.Entity.Article;
import blog.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class articleDAO {
    @Autowired
    SessionFactory sessionFactory;

    public int maxId(){
        String hql = "select Max(id) from Article";
        Query query =  sessionFactory.openSession().createQuery(hql);
        return (Integer) query.uniqueResult();
    }


    public void addArticle(Article article){
        Session session = sessionFactory.openSession();
        session.save(article);
        session.close();
    }

    public Article searchArticle(int id){
        String hql = "from Article where id = ?";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,id);
        return (Article) query.uniqueResult();
    }

    public User check(){
        String hql = "from User where name = ?";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, ConfigHelper.getUserName());
        return (User) query.uniqueResult();
    }

    public  void updateArticle(Article article){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(article);
        session.getTransaction().commit();
        session.close();
    }

}
