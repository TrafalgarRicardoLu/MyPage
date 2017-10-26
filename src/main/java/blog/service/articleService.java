package blog.service;

import blog.DAO.articleDAO;
import blog.Entity.Article;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
@Service
public class articleService {
    @Autowired
    articleDAO articleDAO;

    String[] month = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public int maxId() {
        return articleDAO.maxId();
    }


    public void addArtilce(Article article) {

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month1 = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        article.setDate(month[month1]+"  "+day+",  "+year);

        String content = article.getContent();
        PegDownProcessor pegDownProcessor = new PegDownProcessor();
        String contentResult = pegDownProcessor.markdownToHtml(content);
        article.setContent(contentResult);

        articleDAO.addArtilce(article);
    }

    public Article searchArticle(int id) {
        return articleDAO.searchArticle(id);
    }
}
