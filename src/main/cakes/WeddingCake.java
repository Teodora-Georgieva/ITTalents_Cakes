package main.cakes;

import main.utils.Constants;

public class WeddingCake extends Cake{
    private int levels;

    public WeddingCake(String name, String description, double price, int numOfPieces, String type, int levels){
        super(name, description, price, numOfPieces, type);
        if(levels > 0){
            this.levels = levels;
        }
        else{
            this.levels = 3;
        }
    }

    @Override
    public String getKind() {
        return "WeddingCake";
    }

    @Override
    public int getKindIndex() {
        return 3;
    }

    @Override
    String setDefaultType() {
        return "big";
    }

    @Override
    String getValidTypes() {
        String validTypes = String.join("", Constants.weddingTypes);
        return validTypes;
    }
}