package main.people.clients;
import main.Order;
import main.Sweetshop;
import main.cakes.Cake;
import main.people.Deliverer;
import main.people.Person;
import main.utils.Generator;

import java.util.ArrayList;


public abstract class Client extends Person {
    private Sweetshop favouriteSweetshop;

    Client(String name, String phoneNumber){
        super(name, phoneNumber);
    }

    public void setFavouriteSweetshop(Sweetshop favouriteSweetshop) {
        this.favouriteSweetshop = favouriteSweetshop;
    }

    public void orderCakes(){
        ArrayList<Cake> cakesToOrder = new ArrayList<Cake>();
        for (int i = 0; i < getNumberOfCakesToOrder(); i++) {
            String kind = Generator.generateKindOfCake();
            String type = Generator.generateTypeOfCake(kind);
            if(favouriteSweetshop.isAvailableCake(kind, type)){
                cakesToOrder.add(favouriteSweetshop.getCake(kind, type));
            }
        }

        Deliverer d = this.favouriteSweetshop.generateDeliverer();
        Order order = new Order(this, "Sofia", cakesToOrder, "tomorrow");
        d.addOrder(order);
        double price = order.getPrice();
        double discount = calculateDiscount(price);
        double sumToPay = price - discount;
        double tip = giveTip(sumToPay);
        favouriteSweetshop.receiveIncome(sumToPay, this);
        d.receiveTip(tip);
    }

    abstract double calculateDiscount(double price);

    abstract int getNumberOfCakesToOrder();

    abstract double giveTip(double price);

    @Override
    public String toString() {
        return "client name: " + this.name;
    }
}