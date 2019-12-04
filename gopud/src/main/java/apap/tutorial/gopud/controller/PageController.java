package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.RoleService;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(@ModelAttribute UserModel user, Model model){
        model.addAttribute("listRole", roleService.findAll());
        model.addAttribute(user);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
