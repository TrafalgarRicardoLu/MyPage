package blog.service;

import LibraryManagementSystem.Entity.User;
import Utils.imgResize;
import blog.DAO.articleDAO;
import blog.Entity.Article;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
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

        //format data
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month1 = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        article.setDate(month[month1]+"  "+day+",  "+year);

        //transfer markdown to html
        String content = article.getContent();
        PegDownProcessor pegDownProcessor = new PegDownProcessor();
        content = pegDownProcessor.markdownToHtml(content);
        content=content.replaceAll("</.*\\bcode\\b>","</pre>");
        content=content.replaceAll("<.*\\bcode\\b>","<pre>");
        content=content.replaceAll("&emsp;&emsp;","</br>&emsp;&emsp;");
        article.setContent(content);

        //resize image
        imgResize.saveMinPhoto(imgPath+".jpg",imgPath+"-S.jpg",200,1);
        imgResize.saveMinPhoto(imgPath+".jpg",imgPath+"-M.jpg",800,1);
        imgResize.saveMinPhoto(imgPath+".jpg",imgPath+"-L.jpg",2000,1);


        articleDAO.addArticle(article);
    }

    public void updateArticle(Article article,String imgPath) throws Exception {
        //transfer markdown to html
        String content = article.getContent();
        PegDownProcessor pegDownProcessor = new PegDownProcessor();
        content = pegDownProcessor.markdownToHtml(content);
        content=content.replaceAll("</.*\\bcode\\b>","</pre>");
        content=content.replaceAll("<.*\\bcode\\b>","<pre>");
        content=content.replaceAll("&emsp;&emsp;","</br>&emsp;&emsp;");
        article.setContent(content);

        //resize image
        if(imgPath!=null) {
            File image_S = new File(imgPath + "-S.jpg");
            File image_M = new File(imgPath + "-M.jpg");
            File image_L = new File(imgPath + "-L.jpg");
            if (image_S.exists()) image_S.delete();
            if (image_M.exists()) image_M.delete();
            if (image_L.exists()) image_L.delete();
            imgResize.saveMinPhoto(imgPath + ".jpg", imgPath + "-S.jpg", 200, 1);
            imgResize.saveMinPhoto(imgPath + ".jpg", imgPath + "-M.jpg", 800, 1);
            imgResize.saveMinPhoto(imgPath + ".jpg", imgPath + "-L.jpg", 2000, 1);
        }
        articleDAO.updateArticle(article);
    }

    public Article searchArticle(int id) {
        return articleDAO.searchArticle(id);
    }

    public User check(){
        return articleDAO.check();
    }
}
