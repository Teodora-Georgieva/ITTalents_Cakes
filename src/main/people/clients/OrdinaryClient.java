package main.people.clients;

import main.utils.Generator;

import java.util.ArrayList;

public class OrdinaryClient extends Client{
    private ArrayList<Integer> vouchers;

    public OrdinaryClient(String name, String phoneNumber){
        super(name, phoneNumber);
        vouchers = new ArrayList<Integer>();
        int numOfVouchers = Generator.generateRandomNumber(1,4);
        for (int i = 0; i < numOfVouchers; i++) {
            vouchers.add(Generator.generateRandomNumber(10, 30));
        }
    }

    @Override
    double calculateDiscount(double price) {
        double discount = 0;
        for(int voucher : vouchers){
            discount+=voucher;
            if(discount >= price){
                discount = price;
                break;
            }
        }

        return discount;
    }

    @Override
    int getNumberOfCakesToOrder() {
        return Generator.generateRandomNumber(1, 3);
    }

    @Override
    double giveTip(double price) {
        return 2.0/100 * price;
    }
}