package main;

import main.cakes.KidCake;
import main.cakes.SpecialCake;
import main.cakes.StandardCake;
import main.cakes.WeddingCake;
import main.people.Deliverer;
import main.people.clients.Client;
import main.people.clients.CorporateClient;
import main.people.clients.OrdinaryClient;
import main.utils.Generator;

import java.util.ArrayList;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Sweetshop sweetshop = new Sweetshop("Sweet Talents", "Sofia", "0888998877");
        for (int i = 0; i < 5; i++) {
            Deliverer deliverer = new Deliverer(("Deliverer" + (i+1)), "");
            sweetshop.addDeliverer(deliverer);
        }

        for (int i = 0; i < 30; i++) {
            String kind = Generator.generateKindOfCake();
            String type = Generator.generateTypeOfCake(kind);
            String name = "cake" + (i+1);
            double price = Generator.generateRandomNumber(40, 350);
            int numOfPieces = Generator.generateRandomNumber(10, 200);

            switch (kind){
                case "KidCake":
                    String kidName = "kid" + (i+1);
                    sweetshop.addToCatalogue(new KidCake(name, "", price, numOfPieces, type, kidName));
                    break;
                case "SpecialCake":
                    String eventName = "event" + (i+1);
                    sweetshop.addToCatalogue(new SpecialCake(name, "", price, numOfPieces, type, eventName));
                    break;
                case "StandardCake":
                    Random r = new Random();
                    boolean hasSyrup = r.nextBoolean();
                    sweetshop.addToCatalogue(new StandardCake(name, "", price, numOfPieces, type, hasSyrup));
                    break;
                case "WeddingCake":
                    int levels = Generator.generateRandomNumber(2, 6);
                    sweetshop.addToCatalogue(new WeddingCake(name, "", price, numOfPieces, type, levels));
                    break;
            }
        }

        ArrayList<Client> clients = new ArrayList<>();
        Client client;
        for (int i = 0; i < 5; i++) {
            String name = "CorporateClient" + (i+1);
            client = new CorporateClient(name, "");
            client.setFavouriteSweetshop(sweetshop);
            clients.add(client);
            name = "OrdinaryClient" + (i+1);
            client = new OrdinaryClient(name, "");
            client.setFavouriteSweetshop(sweetshop);
            clients.add(client);
        }

        System.out.println("Showing cakes before orders:");
        sweetshop.printCatalogue();
        System.out.println();

        for(Client c : clients){
            c.orderCakes();
        }

        System.out.println("Showing cakes after orders:");
        sweetshop.printCatalogue();
        System.out.println();

        System.out.println("Sweetshop income: " + sweetshop.getIncome());
        System.out.println();

        System.out.println("Printing sorted deliverers: ");
        sweetshop.printDeliverersByTip();
        System.out.println();

        System.out.println("Showing most sold kind of cake: ");
        sweetshop.printMostSoldKind();
        System.out.println();

        System.out.println("Showing deliverer with most orders: ");
        sweetshop.showDelivererWithMostOrders();
        System.out.println();

        System.out.println("Showing wealthiest client: ");
        sweetshop.getWealthiestClient();
        System.out.println();
    }
}