package com.finalproject.serviceone.controller;

import com.finalproject.serviceone.model.Buy;
import com.finalproject.serviceone.model.Sell;
import com.finalproject.serviceone.model.User;
import com.finalproject.serviceone.repository.BuyRepository;
import com.finalproject.serviceone.repository.SellRepository;
import com.finalproject.serviceone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller

public class BuyAndSellController {

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private SellRepository sellRepository;

    @Autowired
    private UserRepository userRepository;




    public User getUsers() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = (User) auth.getPrincipal();
        Optional<User> user = userRepository.findByEmail(loggedUser.getEmail());
        return user.get();
    }

    @GetMapping(value = "/order")
    public String BuyAccess(Model model){

        model.addAttribute("buys", buyRepository.findAll());
        model.addAttribute("sells", sellRepository.findAll());
        model.addAttribute("buy", new Buy());
        model.addAttribute("sell", new Sell());


        return "OrderPage";
    }

    @GetMapping(value = "/orderBuy")
  public String Buy(Model model, Buy buy, HttpServletRequest request){

        User user = getUsers();
        buy.setBuyer(user);
        buy.setBuyTotal(buy.getBuyPrice()*buy.getBuyAmount());
        model.addAttribute("buy", buyRepository.save(buy));

        return "redirect:/order";

    }



    @GetMapping(value = "/orderSell")
    public String Sell(Model model, Sell sell){

        User user = getUsers();
        sell.setSeller(user);
        sell.setSellTotal(sell.getSellPrice()*sell.getSellAmount());
        model.addAttribute("sell", sellRepository.save(sell));
        return "redirect:/order";
    }


}
