package LibraryManagementSystem.controller;

import LibraryManagementSystem.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import LibraryManagementSystem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "loginCheck", method = RequestMethod.GET)
    public String loginCheck(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");
        User user = userService.searchUser(name);
        if (user.getPassword().equals( password)){
            return "user/index";}
        else {
            return "user/fail";
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String save() {
        return "user/save";
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String all(Map<String, Object> map) {
        List<User> users = userService.allUser();
        map.put("users", users);
        return "all";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(HttpServletRequest httpServletRequest) {
        User user = new User();
        user.setName(httpServletRequest.getParameter("name"));
        user.setPassword(httpServletRequest.getParameter("password"));
        userService.saveUser(user);
        return "user/success";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search() {
        return "user/search";
    }

    @RequestMapping(value = "searchUser", method = RequestMethod.GET)
    public String searchUser(HttpServletRequest httpServletRequest) {
        String userName = httpServletRequest.getParameter("name");
        User user = userService.searchUser(userName);
        httpServletRequest.setAttribute("user", user);
        return "user/searchResult";
    }


    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete() {
        return "user/delete";
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest httpServletRequest) {
        String userName = httpServletRequest.getParameter("name");
        userService.deleteUser(userName);
        return "user/success";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update() {
        return "user/update";
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest httpServletRequest) {
        String userName = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("newPassword");
        userService.updateUser(userName, password);
        return "user/success";
    }


}
