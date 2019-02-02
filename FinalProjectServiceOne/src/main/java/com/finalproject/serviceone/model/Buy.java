package com.finalproject.serviceone.model;

import javax.persistence.*;


@Entity
@Table(name="buy")
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="buy_id")
    private int buy_id;



    @Column(name = "buyPrice")
    private int buyPrice;

    @Column(name = "buyAmount")
    private int buyAmount;

    @Column(name = "buyTotal")
    private int buyTotal;


    @ManyToOne(cascade = CascadeType.ALL)
    private User buyer;



    public Buy(int buyPrice, int buyAmount, int buyTotal) {
        this.buyPrice = buyPrice;
        this.buyAmount = buyAmount;
        this.buyTotal = buyTotal;

    }

    public Buy() {
    }

    public int getBuy_id() {
        return buy_id;
    }

    public void setBuy_id(int buy_id) {
        this.buy_id = buy_id;
    }


    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public int getBuyTotal() {
        return buyTotal;
    }

    public void setBuyTotal(int buyTotal) {
        this.buyTotal = buyTotal;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
}
