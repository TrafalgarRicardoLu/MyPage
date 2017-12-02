package blog.service;

import LibraryManagementSystem.Entity.User;
import Utils.imgResize;
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


    public void addArticle(Article article,String imgPath) throws Exception {

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month1 = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        article.setDate(month[month1]+"  "+day+",  "+year);

        String content = article.getContent();
        PegDownProcessor pegDownProcessor = new PegDownProcessor();
        content = pegDownProcessor.markdownToHtml(content);
        content=content.replaceAll("</.*\\bcode\\b>","</pre>");
        content=content.replaceAll("<.*\\bcode\\b>","<pre>");
        content=content.replaceAll("&emsp;&emsp;","</br>&emsp;&emsp;");
        article.setContent(content);

        imgResize.saveMinPhoto(imgPath+".jpg",imgPath+"-S.jpg",200,1);
        imgResize.saveMinPhoto(imgPath+".jpg",imgPath+"-M.jpg",800,1);
        imgResize.saveMinPhoto(imgPath+".jpg",imgPath+"-L.jpg",2000,1);


        articleDAO.addArticle(article);
    }

    public Article searchArticle(int id) {
        return articleDAO.searchArticle(id);
    }

    public User check(){
        return articleDAO.check();
    }
}
