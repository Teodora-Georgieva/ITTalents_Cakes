package main.cakes;

import main.utils.Constants;
import main.utils.Validator;

public class KidCake extends Cake{
    private String kidName;

    public KidCake(String name, String description, double price, int numOfPieces, String type, String kidName){
        super(name, description, price, numOfPieces, type);
        if(Validator.isValidString(kidName)) {
            this.kidName = kidName;
        }
        else{
            this.kidName = "Maria";
        }
    }

    @Override
    public String getKind() {
        return "KidCake";
    }

    @Override
    public int getKindIndex() {
        return 0;
    }

    @Override
    String setDefaultType() {
        return "birthday";
    }

    @Override
    String getValidTypes() {
        String validTypes = String.join("", Constants.kidTypes);
        return validTypes;
    }
}
