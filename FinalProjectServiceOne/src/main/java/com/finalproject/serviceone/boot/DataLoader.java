package com.finalproject.serviceone.boot;

import com.finalproject.serviceone.model.Buy;
import com.finalproject.serviceone.model.Sell;
import com.finalproject.serviceone.model.User;
import com.finalproject.serviceone.repository.BuyRepository;
import com.finalproject.serviceone.repository.SellRepository;
import com.finalproject.serviceone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private SellRepository sellRepository;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... strings) throws Exception {


        // Remove the comments to make
        /*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPassword1 = passwordEncoder.encode("umair");

        User user = new User("Umair", "Mehmood", "UmairMehmood", "umair@gmail.com", hashPassword1, 100, 100);


        Buy buy = new Buy();
        buy.setBuy_id(12);
        buy.setBuyPrice(123);
        buy.setBuyAmount(21);
        buy.setBuyTotal(buy.getBuyPrice()* buy.getBuyAmount());


        Sell sell = new Sell();
        sell.setSellPrice(12);
        sell.setSellAmount(123);
        sell.setSellTotal(sell.getSellPrice()*sell.getSellAmount());

        userRepository.save(user);

        buy.setBuyer(user);
        buyRepository.save(buy);

        sell.setSeller(user);

        sellRepository.save(sell);*/
    }
}