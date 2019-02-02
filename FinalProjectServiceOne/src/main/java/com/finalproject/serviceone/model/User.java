package com.finalproject.serviceone.model;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "registration")
public class User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;


    @NotEmpty
    @NotNull
    @Column(name="firstname")
    private String firstName;



    @NotEmpty
    @NotNull
    @Column(name="lastname")
    private String lastName;


    @NotEmpty
    @NotNull
    @Column(name="username" , nullable = false, unique = true)
    private String userName;


    @NotEmpty
    @NotNull
    @Column(name="email", nullable = false, unique = true)
    private String email;


    @NotEmpty
    @NotNull
    @Column(name="password")
    private String password;


    @Column(name="bitcoins")
    private int bitcoins;


    @Column(name="dollars")
    private int dollars;


    // BUY JPA RELATIONSHIP
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "buyer")
    private List<Buy> buy = new ArrayList<>();



    // SELL JPA RELATIONSHIP
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "seller")
    private List<Sell> sell = new ArrayList<>();






    public User(){

    }


    public User(User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.bitcoins = user.getBitcoins();
        this.dollars = user.getDollars();
    }

    public User(@NotEmpty @NotNull String firstName, @NotEmpty @NotNull String lastName, @NotEmpty @NotNull String userName, @NotEmpty @NotNull String email, @NotEmpty @NotNull String password, int bitcoins, int dollars) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.bitcoins = bitcoins;
        this.dollars = dollars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBitcoins() {
        return bitcoins;
    }

    public void setBitcoins(int bitcoins) {
        this.bitcoins = bitcoins;
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }



    public List<Buy> getBuyer() {
        return buy;
    }

    public void setBuyer(List<Buy> buy) {
        this.buy = buy;
    }


    public List<Sell> getSeller() {
        return sell;
    }

    public void setSeller(List<Sell> seller) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", bitcoins=" + bitcoins +
                ", dollars=" + dollars +
                ", buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
