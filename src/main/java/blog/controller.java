package blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog")
public class controller {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "blog/index";
    }

    @RequestMapping(value = "article1", method = RequestMethod.GET)
    public String article1() {
        return "blog/article1";
    }

    @RequestMapping(value = "article2", method = RequestMethod.GET)
    public String article2() {
        return "blog/article2";
    }

    @RequestMapping(value = "previousArticle", method = RequestMethod.GET)
    public String previousArticle(HttpServletRequest httpServletRequest) {
        String pre = "blog/article";
        String num = httpServletRequest.getParameter("id");
        int number = Integer.parseInt(num);
        number--;
        httpServletRequest.setAttribute("id",number);
        return pre + number;
    }

    @RequestMapping(value = "nextArticle", method = RequestMethod.GET)
    public String nextArticle(HttpServletRequest httpServletRequest) {
        String pre = "blog/article";
        String num = httpServletRequest.getParameter("id");
        int number = Integer.parseInt(num);
        number++;
        httpServletRequest.setAttribute("id",number);
        return pre + number;
    }

    @RequestMapping(value = "changeArticle", method = RequestMethod.GET)
    public String changeArticle(HttpServletRequest httpServletRequest) {
        String pre = "blog/article";
        String imagePath = "/assets/images/blog/article";
        String id_s = httpServletRequest.getParameter("id");
        int id = Integer.parseInt(id_s);
        String change = httpServletRequest.getParameter("change");
        if(change=="pre"){
            id--;
        }else if(change=="next"){
            id++;
        }
        if(id==0){
            return "blog/index";
        }
        String preImagePath = imagePath+(id-1)+".jpg";
        String nextImagePath = imagePath+(id+1)+".jpg";
        httpServletRequest.setAttribute("id",id);
        imagePath=imagePath+id+".jpg";
        httpServletRequest.setAttribute("imagePath",imagePath);
        httpServletRequest.setAttribute("preImagePath",preImagePath);
        httpServletRequest.setAttribute("nextImagePath",nextImagePath);
        return "blog/article";
    }

}
