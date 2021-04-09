package main;

import main.cakes.Cake;
import main.cakes.StandardCake;
import main.people.Deliverer;
import main.people.clients.Client;
import main.utils.Generator;
import main.utils.Validator;

import java.util.*;

public class Sweetshop {
    private String name;
    private String address;
    private String phoneNumber;
    private HashSet<Deliverer> deliverers;
    private HashMap<String, HashMap<String, ArrayList<Cake>>> catalogue;
    private double income;
    private Client wealthiestClient;
    private double moneyFromWealthiestClient;
    private int[] soldKindsOfCakes = new int[4];

    public Sweetshop(String name, String address, String phoneNumber) {
        if(Validator.isValidString(name)) {
            this.name = name;
        }
        else{
            this.name = "Sweet Talents";
        }

        if(Validator.isValidString(address)) {
            this.address = address;
        }
        else{
            this.address = "Sofia";
        }

        if(Validator.isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        else{
            this.phoneNumber = "0888112233";
        }

        this.income = 0;

        deliverers = new HashSet<>();

        catalogue = new HashMap<>();
        catalogue.put("StandardCake", new HashMap<>());
        catalogue.get("StandardCake").put("biscuit", new ArrayList<>());
        catalogue.get("StandardCake").put("eclair", new ArrayList<>());
        catalogue.get("StandardCake").put("fruit", new ArrayList<>());
        catalogue.get("StandardCake").put("choco", new ArrayList<>());

        catalogue.put("SpecialCake", new HashMap<>());
        catalogue.get("SpecialCake").put("anniversary", new ArrayList<>());
        catalogue.get("SpecialCake").put("company", new ArrayList<>());
        catalogue.get("SpecialCake").put("reclame", new ArrayList<>());

        catalogue.put("WeddingCake", new HashMap<>());
        catalogue.get("WeddingCake").put("big", new ArrayList<>());
        catalogue.get("WeddingCake").put("average", new ArrayList<>());
        catalogue.get("WeddingCake").put("small", new ArrayList<>());

        catalogue.put("KidCake", new HashMap<>());
        catalogue.get("KidCake").put("birthday", new ArrayList<>());
        catalogue.get("KidCake").put("baptism", new ArrayList<>());
        catalogue.get("KidCake").put("proshtapulnik", new ArrayList<>());


        for(String type : catalogue.get("StandardCake").keySet()){
            catalogue.get("StandardCake").get(type).sort((c1, c2) -> ((Double)(c2.getPrice())).compareTo((Double)(c1.getPrice())));
        }

        for(String type : catalogue.get("SpecialCake").keySet()){
            catalogue.get("SpecialCake").get(type).sort((c1, c2) -> ((Double)(c2.getPrice())).compareTo((Double)(c1.getPrice())));
        }

        for(String type : catalogue.get("WeddingCake").keySet()){
            catalogue.get("WeddingCake").get(type).sort((c1, c2) ->
                                                       ((Integer)(c2.getNumOfPieces())).compareTo((Integer)(c1.getNumOfPieces())));
        }

        for(String type : catalogue.get("KidCake").keySet()){
            catalogue.get("KidCake").get(type).sort((c1, c2) ->
                    ((Integer)(c2.getNumOfPieces())).compareTo((Integer)(c1.getNumOfPieces())));
        }
    }

    void addDeliverer(Deliverer deliverer){
        this.deliverers.add(deliverer);
    }

    public Deliverer generateDeliverer(){
        Random r = new Random();
        ArrayList<Deliverer> del = new ArrayList<>();
        del.addAll(deliverers);
        return del.get(r.nextInt(del.size()));
    }

    public boolean isAvailableCake(String kind, String type){
        return catalogue.get(kind).get(type).size() > 0;
    }

    public Cake getCake(String kind, String type){
        Cake cake = catalogue.get(kind).get(type).get(0);
        catalogue.get(kind).get(type).remove(0);
        int idx = cake.getKindIndex();
        this.soldKindsOfCakes[idx]+=1;
        return cake;
    }

    public void receiveIncome(double income, Client client){
        if(income > 0) {
            this.income += income;
        }

        if(this.wealthiestClient == null){
            this.wealthiestClient = client;
            this.moneyFromWealthiestClient = income;
        }
        else{
            if(income > this.moneyFromWealthiestClient){
                this.moneyFromWealthiestClient = income;
                this.wealthiestClient = client;
            }
        }
    }

    public void addToCatalogue(Cake cake){
        String kind = cake.getKind();
        String type = cake.getType();
        catalogue.get(kind).get(type).add(cake);
    }

    public void printCatalogue(){
        for(String kind : this.catalogue.keySet()){
            System.out.println(kind + ":");
            for(String type : this.catalogue.get(kind).keySet()){
                System.out.println("    type: " + type);
                for(Cake cake : this.catalogue.get(kind).get(type)){
                    System.out.println("        " + cake);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public double getIncome() {
        return income;
    }

    void printDeliverersByTip(){
        ArrayList<Deliverer> list = new ArrayList<>();
        list.addAll(this.deliverers);
        list.sort((d1, d2) -> d2.getTip().compareTo(d1.getTip()));
        for(Deliverer d : list){
            System.out.println(d);
        }
    }

    void showDelivererWithMostOrders(){
        ArrayList<Deliverer> list = new ArrayList<>();
        list.addAll(this.deliverers);
        list.sort((d1, d2) -> d1.getCountOfOrders() - d2.getCountOfOrders());
        System.out.println(list.get(list.size() - 1));
    }

    public void getWealthiestClient(){
        System.out.println(this.wealthiestClient);
        System.out.println("Money given for cakes: " + this.moneyFromWealthiestClient);
    }

    public void printMostSoldKind(){
        int maxIdx = 0;
        int maxValue = soldKindsOfCakes[0];
        for (int i = 1; i < soldKindsOfCakes.length; i++) {
            if(soldKindsOfCakes[i] > maxValue){
                maxIdx = i;
                maxValue = soldKindsOfCakes[i];
            }
        }

        switch (maxIdx){
            case 0:
                System.out.println("KidCake"); break;
            case  1:
                System.out.println("SpecialCake"); break;
            case 2:
                System.out.println("StandardCake"); break;
            case 3:
                System.out.println("WeddingCake"); break;
        }
    }
}