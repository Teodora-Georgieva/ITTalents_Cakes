package main.cakes;

import main.utils.Validator;

public abstract class Cake {
    private String name;
    private String description;
    private double price;
    private int numOfPieces;
    private String type;

    public Cake(String name, String description, double price, int numOfPieces, String type) {
        if(Validator.isValidString(name)) {
            this.name = name;
        }
        else{
            this.name = "Choco cake";
        }

        if(Validator.isValidString(description)) {
            this.description = description;
        }
        else{
            this.description = "yummy";
        }

        if(price > 0) {
            this.price = price;
        }
        else{
            this.price = 50;
        }

        if(numOfPieces > 0) {
            this.numOfPieces = numOfPieces;
        }
        else{
            this.numOfPieces = 16;
        }

        if(validateType(type)) {
            this.type = type;
        }
        else{
            this.type = setDefaultType();
        }
    }

    public abstract String getKind();
    public abstract int getKindIndex();

    boolean validateType(String type){
        String validTypes = getValidTypes();
        return validTypes.contains(type);
    }

    abstract String setDefaultType();
    abstract String getValidTypes();

    public double getPrice() {
        return price;
    }

    public int getNumOfPieces() {
        return numOfPieces;
    }

    public String getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", numOfPieces=" + numOfPieces +
                ", kind = " + this.getKind() +
                ", type='" + type + '\'' +
                '}';
    }
}