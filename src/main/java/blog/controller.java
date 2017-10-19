package blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog")
public class controller {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest httpServletRequest) {
        int listId = 0;
        httpServletRequest.setAttribute("listId",listId);
        return "blog/index";
    }

    @RequestMapping(value = "changeArticle", method = RequestMethod.GET)
    public String changeArticle(HttpServletRequest httpServletRequest) {
        String pre = "blog/article";
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
        String preImagePath = id==1?imagePath + id + ".jpg":imagePath + (id - 1) + ".jpg";
        String nextImagePath = imagePath + (id + 1) + ".jpg";
        imagePath = imagePath + id + ".jpg";
        httpServletRequest.setAttribute("id", id);
        httpServletRequest.setAttribute("imagePath", imagePath);
        httpServletRequest.setAttribute("preImagePath", preImagePath);
        httpServletRequest.setAttribute("nextImagePath", nextImagePath);
        return "blog/article";
    }

}
