package blog.DAO;


import Utils.ConfigHelper;
import blog.Entity.Article;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class articleDAO {
    @Autowired
    SessionFactory sessionFactory;

    public int maxId() {
        String hql = "select Max(id) from Article";
        Query query = sessionFactory.openSession().createQuery(hql);
        return (Integer) query.uniqueResult();
    }


    public void addArticle(Article article) {
        Session session = sessionFactory.openSession();
        session.save(article);
        session.close();
    }

    public Article searchArticle(int id) {
        String hql = "from Article where id = ?";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        return (Article) query.uniqueResult();
    }

    public String check() {
        String sql = "select * from User where name = ?";
        String ans = "";
        Session session = sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery(sql).addScalar("password", StandardBasicTypes.STRING);
        query.setParameter(0, ConfigHelper.getUserName());
        Object object = query.uniqueResult();
        ans = ConfigHelper.getUserName() + "&" + object;
        return ans;
    }

    public void updateArticle(Article article) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(article);
        session.getTransaction().commit();
        session.close();
    }

}
