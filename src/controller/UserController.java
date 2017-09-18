package controller;

import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;


@Controller

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "save" ,method = RequestMethod.GET)
    public String save(){
        userService.save();
        return "all";
    }
}
