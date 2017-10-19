package blog.DAO;

import blog.Entity.Article;
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


    public void addArtilce(Article article){
        Session session = sessionFactory.openSession();
        session.save(article);
        session.close();
        return;
    }

    public Article searchArticle(int id){
        String hql = "from Article where id = ?";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,id);
        return (Article) query.uniqueResult();
    }

}
