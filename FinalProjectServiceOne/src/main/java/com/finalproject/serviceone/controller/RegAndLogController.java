package com.finalproject.serviceone.controller;

import com.finalproject.serviceone.model.Buy;
import com.finalproject.serviceone.model.Sell;
import com.finalproject.serviceone.model.User;
import com.finalproject.serviceone.repository.BuyRepository;
import com.finalproject.serviceone.repository.SellRepository;
import com.finalproject.serviceone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegAndLogController {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private SellRepository sellRepository;


     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @RequestMapping(path = "/")
    public String index() {
        return "WelcomePage";
    }

//    To delete users
//    @GetMapping("/users/delete/{Id}")
//    public String deleteUser(@PathVariable(name = "Id") int Id) {
//        userRepository.deleteById(Id);
//        return "redirect:/users";
//    }

    // To View Users List
    @GetMapping("/users")
    public String getAll(Model model){
        model.addAttribute("user", userRepository.findAll());
        return "UsersList";
    }


   //Registration Methods
    @GetMapping("/register")
    public String showRegistration(Model model){
        model.addAttribute("users",  new User());
        return "RegisterPage";
    }


    @GetMapping("/registerPage")
    public String registerUser(Model model, User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBitcoins(100);
        user.setDollars(100);
        model.addAttribute("users", userRepository.save(user));
        System.out.println("userid: " + user.getId());
        System.out.println(user.toString());
        return "redirect:/register";
    }

    //Login Methods
    @GetMapping("/loginPageAccess")
    public String showLogin(){
        return "LoginPage";
    }


    @GetMapping("/login")
    public String login(){
        return "redirect:/order";
    }




}
