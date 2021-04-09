package main.cakes;

import main.utils.Constants;

public class StandardCake extends Cake {
    private boolean hasSyrup;

    public StandardCake(String name, String description, double price, int numOfPieces, String type, boolean hasSyrup){
        super(name, description, price, numOfPieces, type);
        this.hasSyrup = hasSyrup;
    }

    @Override
    public String getKind() {
        return "StandardCake";
    }

    @Override
    public int getKindIndex() {
        return 2;
    }

    @Override
    String setDefaultType() {
        return "choco";
    }

    @Override
    String getValidTypes() {
        String validTypes = String.join("", Constants.standardTypes);
        return validTypes;
    }
}