package blog.service;

import blog.DAO.articleDAO;
import blog.Entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class articleService {
    @Autowired
    articleDAO articleDAO;


    public int maxId(){
        return articleDAO.maxId();
    }


    public void addArtilce(Article article){
        articleDAO.addArtilce(article);
    }

    public Article searchArticle(int id){
        return articleDAO.searchArticle(id);
    }
}
