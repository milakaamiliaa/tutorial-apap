package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.model.IModel;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute(user);
        return "home";
    }

    @RequestMapping(value = "/update-password/{username}", method = RequestMethod.GET)
    private String updatePassword(@PathVariable(value="username") String username, Model model) {
        UserModel user = userService.getUser(username);
        model.addAttribute("user", user);
        model.addAttribute("username", username);
        model.addAttribute("pesan", "");
        return "form-update-password";
    }

    @RequestMapping(value = "/update-password/{username}", method = RequestMethod.POST)
    private String updatePasswordSubmit(@PathVariable(value="username") String username, String oldPass, String newPass, String confirmedPass, Model model) {
        UserModel user = userService.getUser(username);

        if (newPass.matches(".*[a-zA-Z].*") && newPass.matches(".*[0-9].*") && newPass.length() >= 8) {
            if (newPass.equals(confirmedPass) == false) {
                model.addAttribute("pesan", "Password tidak sesuai");
                return "form-update-password";

            } else if (newPass.equals(oldPass)){
                model.addAttribute("pesan", "Password sama");
                return "form-update-password";

            }else {
                boolean valid = userService.checkPassword(user.getPassword(), oldPass);
                if (valid == true) {
                    userService.updatePassword(username, newPass);
                    return "update-password";
                } else {
                    model.addAttribute("pesan", "Password tidak sesuai");
                    return "form-update-password";
                }
            }
        } else {
            model.addAttribute("pesan", "Password harus mengandung huruf dan angka serta minimal 8 karakter");
            return "form-update-password";
        }

    }
}
