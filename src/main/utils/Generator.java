package main.utils;

import java.util.Random;

public abstract class Generator {
    public static int generateRandomNumber(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static String generateTypeOfCake(String kind){
        Random r = new Random();

        if(kind.equals("KidCake")){
            return Constants.kidTypes[r.nextInt(Constants.kidTypes.length)];
        }

        if(kind.equals("SpecialCake")){
            return Constants.specialTypes[r.nextInt(Constants.specialTypes.length)];
        }

        if(kind.equals("StandardCake")){
            return Constants.standardTypes[r.nextInt(Constants.standardTypes.length)];
        }

        return Constants.weddingTypes[r.nextInt(Constants.weddingTypes.length)];
    }

    public static String generateKindOfCake(){
        int num = Generator.generateRandomNumber(1, 4);
        switch (num){
            case 1: return "KidCake";
            case 2: return "SpecialCake";
            case 3: return "StandardCake";
            default: return "WeddingCake";
        }
    }
}