package main.people;

import main.Order;

import java.util.HashSet;
import java.util.Objects;

public class Deliverer extends Person {
    private HashSet<Order> orders;
    private double tip;

    public Deliverer(String name, String phoneNumber){
        super(name, phoneNumber);
        this.orders = new HashSet<Order>();
        this.tip = 0;
    }

    @Override
    public boolean equals(Object o) {
        super.equals(o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Deliverer deliverer = (Deliverer) o;
        return Double.compare(deliverer.tip, tip) == 0 &&
                Objects.equals(orders, deliverer.orders);
    }

    @Override
    public int hashCode() {
        super.hashCode();
        return Objects.hash(super.hashCode(), orders, tip);
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public void receiveTip(double tip){
        this.tip+=tip;
    }

    public Double getTip() {
        return tip;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", tips: " + this.tip + ", number of orders: " + this.getCountOfOrders();
    }

    public Integer getCountOfOrders(){
        return this.orders.size();
    }
}