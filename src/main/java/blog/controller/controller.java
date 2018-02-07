package blog.controller;

import LibraryManagementSystem.Entity.User;
import blog.Entity.Article;
import blog.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/blog")
public class controller {
    @Autowired
    articleService articleService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest httpServletRequest) {
        int countArticle = articleService.maxId();
        int countPage = (int) Math.ceil(countArticle / 3.0);
        String Page_s = httpServletRequest.getParameter("Page");
        int currentPage = Integer.parseInt(Page_s);
        countArticle -= 3 * (currentPage - 1);

        Map<Integer, Article> articleMap = new LinkedHashMap<Integer, Article>();
        for (int i = countArticle; countArticle - i < 3 && i > 0; i--) {
            Article article = articleService.searchArticle(i);
            articleMap.put(i, article);
        }


        httpServletRequest.setAttribute("currentPage", currentPage);
        httpServletRequest.setAttribute("countPage", countPage);
        httpServletRequest.setAttribute("articleMap", articleMap);


        return "blog/index";
    }

    @RequestMapping(value = "changeArticle", method = RequestMethod.GET)
    public String changeArticle(HttpServletRequest httpServletRequest) {
        //get id and article
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        Article article = articleService.searchArticle(id);

        //get id after change
        String imagePath = "http://120.78.59.213/articlePicture/article";
        String change = httpServletRequest.getParameter("change");
        if (change == null) {

        } else if (change.equals("pre")) {
            id++;
        } else if (change.equals("next")) {
            id--;
        }

        if (id == 0 || id == articleService.maxId() + 1) {
            return "redirect:index?Page=1";
        }

        //get article new title and imagine
        String preImagePath = imagePath + (id + 1) + "/article" + (id + 1) + "-M" + ".jpg";
        String nextImagePath = imagePath + +(id - 1) + "/article" + (id - 1) + "-M" + ".jpg";
        String nextTitle = null;
        String preTitle = null;
        imagePath = imagePath + id + "/article" + id + "-L" + ".jpg";
        if (id == 1) {
            nextImagePath = "/assets/images/blog/banner.jpg";
            nextTitle = "Index";
        }
        if (id == articleService.maxId()) {
            preImagePath = "/assets/images/blog/banner.jpg";
            preTitle = "Index";
        }
        if (id != 1 && id != articleService.maxId()) {
            nextTitle = articleService.searchArticle(id - 1).getTitle();
            preTitle = articleService.searchArticle(id + 1).getTitle();
        }


        httpServletRequest.setAttribute("id", id);
        httpServletRequest.setAttribute("imagePath", imagePath);
        httpServletRequest.setAttribute("preImagePath", preImagePath);
        httpServletRequest.setAttribute("nextImagePath", nextImagePath);
        httpServletRequest.setAttribute("article", article);
        httpServletRequest.setAttribute("preTitle", preTitle);
        httpServletRequest.setAttribute("nextTitle", nextTitle);


        return "blog/article";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("turnPoint", "add");
        String loginStatus = (String) httpServletRequest.getSession().getAttribute("login");
        if(loginStatus!=null && loginStatus.equals("true")){
            return "blog/addArticle";
        }else{
            return "blog/login";
        }
    }

    @RequestMapping(value = "loginCheck", method = RequestMethod.POST)
    public String loginCheck(HttpServletRequest httpServletRequest) {
        User user = articleService.check();
        boolean name = user.getName().equals(httpServletRequest.getParameter("name"));
        boolean password = user.getPassword().equals(httpServletRequest.getParameter("password"));
        String turnPoint = (String) httpServletRequest.getSession().getAttribute("turnPoint");
        if (name && password) {
            httpServletRequest.getSession().setAttribute("login","true");
            if (turnPoint.equals("add"))
                return "blog/addArticle";
            else if (turnPoint.equals("update"))
                return "blog/updateArticle";
        }else{
            httpServletRequest.getSession().setAttribute("login","false");
        }
        return "redirect:index?Page=1";
    }

    @RequestMapping(value = "addArticle", method = RequestMethod.POST)
    public String addArticle(HttpServletRequest httpServletRequest,
                             @RequestParam("image") MultipartFile multipartFile) throws Exception {

        if(httpServletRequest.getSession().getAttribute("login").equals("false")){
            return "blog/login";
        }

        //set title content for article
        Article article = new Article();
        article.setTitle(httpServletRequest.getParameter("title"));
        article.setContent(httpServletRequest.getParameter("content"));

        //save imagine to server
        String img = multipartFile.getOriginalFilename();
        String localImgPath = "/home/Pictures/blog/article" + (articleService.maxId() + 1);
        File file = new File(localImgPath);
        if (!file.exists())
            file.mkdir();
        localImgPath = localImgPath + "/article" + (articleService.maxId() + 1);
        if (multipartFile != null && img.length() > 0) {
            File localImg = new File(localImgPath + ".jpg");
            if (!localImg.exists())
                localImg.createNewFile();
            multipartFile.transferTo(localImg);
        }

        //save
        if (!article.getContent().equals("") && !article.getTitle().equals(""))
            articleService.addArticle(article, localImgPath);
        return "redirect:index?Page=1";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("turnPoint", "update");
        String loginStatus = (String) httpServletRequest.getSession().getAttribute("login");
        if(loginStatus!=null && loginStatus.equals("true")){
            return "blog/updateArticle";
        }else{
            return "blog/login";
        }
    }

    @RequestMapping(value = "updateArticle", method = RequestMethod.POST)
    public String updateArticle(HttpServletRequest httpServletRequest,
                                @RequestParam("image") MultipartFile multipartFile) throws Exception {

        if(httpServletRequest.getSession().getAttribute("login").equals("false")){
            return "blog/login";
        }

        //set title content for article
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        Article article = articleService.searchArticle(id);
        if (httpServletRequest.getParameter("checkTile")!=null)
            article.setTitle(httpServletRequest.getParameter("title"));
        if (httpServletRequest.getParameter("checkContent")!=null)
            article.setContent(httpServletRequest.getParameter("content"));

        //save imagine to server
        String img = multipartFile.getOriginalFilename();
        String localImgPath = "/home/Pictures/blog/article" + id;

        if(httpServletRequest.getParameter("checkImage")!=null) {
            File file = new File(localImgPath);
            if (!file.exists())
                file.mkdir();
            localImgPath = localImgPath + "/article" + id;
            if (multipartFile != null && img.length() > 0) {
                File localImg = new File(localImgPath + ".jpg");
                if (!localImg.exists())
                    localImg.createNewFile();
                else {
                    localImg.delete();
                    localImg.createNewFile();
                }
                multipartFile.transferTo(localImg);
            }
        }
        else{
            localImgPath=null;
        }
        //save
        if (!article.getContent().equals("") && !article.getTitle().equals(""))
            articleService.updateArticle(article, localImgPath);
        return "redirect:index?Page=1";
    }
}
