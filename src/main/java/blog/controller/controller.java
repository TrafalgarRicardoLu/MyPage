package blog.controller;

import blog.Entity.Article;
import blog.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/blog")
public class controller {
    @Autowired
    articleService articleService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest httpServletRequest) {
        Integer listId = articleService.maxId();
        Map<Integer,Article> articleMap = new LinkedHashMap<Integer, Article>();

        for(int i=listId;listId-i<=3 && i>0 ;i--){
            Article article = articleService.searchArticle(i);
            articleMap.put(i,article);
        }
        httpServletRequest.setAttribute("listId",listId+1);
        httpServletRequest.setAttribute("articleMap",articleMap);
        return "blog/index";
    }

    @RequestMapping(value = "changeArticle", method = RequestMethod.GET)
    public String changeArticle(HttpServletRequest httpServletRequest) {
        String imagePath = "/assets/images/blog/article";
        String id_s = httpServletRequest.getParameter("id");
        int id = Integer.parseInt(id_s);
        String change = httpServletRequest.getParameter("change");
        if(change==null){

        } else if (change.equals("pre")) {
            id--;
        } else if(change.equals("next")){
            id++;
        }

        if (id == 0) {
            return "blog/index";
        }

        Article article = articleService.searchArticle(id);
        String preImagePath = id==1?imagePath + id + ".jpg":imagePath + (id - 1) + ".jpg";
        String nextImagePath = imagePath + (id + 1) + ".jpg";
        imagePath = imagePath + id + ".jpg";
        httpServletRequest.setAttribute("id", id);
        httpServletRequest.setAttribute("imagePath", imagePath);
        httpServletRequest.setAttribute("preImagePath", preImagePath);
        httpServletRequest.setAttribute("nextImagePath", nextImagePath);
        httpServletRequest.setAttribute("article",article);
        return "blog/article";
    }

}
