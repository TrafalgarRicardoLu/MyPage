package controller;

import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "save" ,method = RequestMethod.GET)
    public String save(HttpServletRequest httpServletRequest) {
        return "save";
    }

    @RequestMapping(value = "all" ,method = RequestMethod.GET)
    public String all(Map<String,Object> map){
        List<User> users=userService.all();
        map.put("users",users);
        return "all";
    }

    @RequestMapping(value = "add" ,method = RequestMethod.GET)
    public String add(HttpServletRequest httpServletRequest) {
        User user = new User();
        user.setName(httpServletRequest.getParameter("name"));
        user.setPassword(httpServletRequest.getParameter("password"));
        userService.save(user);
        return "success";
    }


}
