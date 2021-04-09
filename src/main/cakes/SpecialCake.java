package main.cakes;

import main.utils.Constants;
import main.utils.Validator;

public class SpecialCake extends Cake{
    private String eventName;

    public SpecialCake(String name, String description, double price, int numOfPieces, String type, String eventName){
        super(name, description, price, numOfPieces, type);
        if(Validator.isValidString(eventName)) {
            this.eventName = eventName;
        }
        else{
            this.eventName = "Anniversary";
        }
    }

    @Override
    public String getKind() {
        return "SpecialCake";
    }

    @Override
    public int getKindIndex() {
        return 1;
    }

    @Override
    String setDefaultType() {
        return "anniversary";
    }

    @Override
    String getValidTypes() {
        String validTypes = String.join("", Constants.specialTypes);
        return validTypes;
    }
}
