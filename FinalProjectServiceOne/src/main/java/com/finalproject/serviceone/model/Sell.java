package com.finalproject.serviceone.model;



import javax.persistence.*;


@Entity
@Table(name = "sell")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sell_id")
    private int sell_id;

    @Column(name = "sellPrice")
    private int sellPrice;

    @Column(name = "sellAmount")
    private int sellAmount;

    @Column(name = "sellTotal")
    private int sellTotal;



    @ManyToOne(cascade = CascadeType.ALL)
    private User seller;



    public Sell(){

    }

    public Sell(int sellPrice, int sellAmount, int sellTotal/*, User seller*/) {
        this.sellPrice = sellPrice;
        this.sellAmount = sellAmount;
        this.sellTotal = sellTotal;

    }

    public int getSell_id() {
        return sell_id;
    }

    public void setSell_id(int sell_id) {
        this.sell_id = sell_id;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
    }

    public int getSellTotal() {
        return sellTotal;
    }

    public void setSellTotal(int sellTotal) {
        this.sellTotal = sellTotal;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
