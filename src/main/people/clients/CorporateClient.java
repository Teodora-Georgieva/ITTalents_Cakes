package main.people.clients;

import main.utils.Generator;

public class CorporateClient extends Client{
    private static double discountPercentage = 10;

    public CorporateClient(String name, String phoneNumber){
        super(name, phoneNumber);
    }

    @Override
    double calculateDiscount(double price) {
        double discount = discountPercentage/100 * price;
        return discount;
    }

    @Override
    int getNumberOfCakesToOrder() {
        return Generator.generateRandomNumber(3, 5);
    }

    @Override
    double giveTip(double price) {
        return 5.0/100 * price;
    }
}
