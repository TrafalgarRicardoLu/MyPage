package blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/blog")
public class controller {
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "blog/index";
    }

    @RequestMapping(value = "text1",method = RequestMethod.GET)
    public String text1(){
        return "blog/text1";
    }

}
