package com.bloggershub.BloggersHub.web.admin;

import com.bloggershub.BloggersHub.model.User;
import com.bloggershub.BloggersHub.repository.UserRepository;
import com.bloggershub.BloggersHub.service.SecurityService;
import com.bloggershub.BloggersHub.service.UserService;
import com.bloggershub.BloggersHub.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value={"/list", "/", ""})
    public String index(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin/users/list";
    }

    @GetMapping("/ban")
    public String ban(@RequestParam("userId") int id) {
        User user = userRepository.findById(id);
        user.setIsBanned(1);
        userService.save(user);
        return "redirect:/admin/users/list";
    }

    @GetMapping("/unban")
    public String unban(@RequestParam("userId") int id) {
        User user = userRepository.findById(id);
        user.setIsBanned(0);
        userService.save(user);
        return "redirect:/admin/users/list";
    }

}
