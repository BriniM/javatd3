package io.brinim.courriers;

import java.util.Scanner;
import java.util.HashMap;

final class Menu {
    final private static Scanner sc = new Scanner(System.in);
    final private static HashMap<String, Runnable> commandes = new HashMap<>();

    public static String question(String cle) {
        System.out.printf("Donner %s: ", cle);
        return sc.nextLine();
    }

    public static String question(String cle, String description) {
        System.out.printf("Donner %s (%s): ", cle, description);
        return sc.nextLine();
    }

    public static String prompt(String req) {
        System.out.printf("%s", req);
        return sc.nextLine();
    }

    public static void ajouterCommande(String commande, Runnable methode) {
        commandes.put(commande, methode);
    }

    public static void loop() {
        for(;;) {
            System.out.printf("Choisir commande %s:", commandes.keySet());
            String input = sc.nextLine();

            commandes.forEach((cmd, meth) -> {
                if (cmd.equalsIgnoreCase(input))
                    meth.run();
            });
        }
    }

    public static void loopAsync() {
        new Thread(Menu::loop).start();
    }
}
