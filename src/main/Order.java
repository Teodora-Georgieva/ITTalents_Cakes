package main;

import main.cakes.Cake;
import main.people.clients.Client;
import main.utils.Validator;

import java.util.ArrayList;

public class Order {
    private Client client;
    private double price;
    private String address;
    private ArrayList<Cake> cakes;
    private String deliveryDate;

    public Order(Client client, String address, ArrayList<Cake> cakes, String deliveryDate) {
        this.client = client;

        if(Validator.isValidString(address)) {
            this.address = address;
        }
        else{
            this.address = "Sofia";
        }

        this.cakes = cakes;
        this.deliveryDate = deliveryDate;

        for(Cake cake : this.cakes){
            this.price+=cake.getPrice();
        }
    }

    public double getPrice() {
        return price;
    }
}