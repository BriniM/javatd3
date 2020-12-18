package io.brinim.courriers;

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.regex.Pattern;

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

    public static String question(String cle, String description, String regexp) throws Exception {
        System.out.printf("Donner %s (%s): ", cle, description);
        var input = sc.nextLine();

        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(input).find())
            return input;
        throw new Exception(String.format("Veuillez reformuler %s", cle));
    }

    public static Enum question(String cle, List<Enum> types) throws Exception {
        System.out.printf("Types disponibles: %s\n", types.toString());
        System.out.printf("Donner %s: ", cle);
        var input = sc.nextLine();

        for (var t : types)
            if (t.toString().equalsIgnoreCase(input))
                return t;

        throw new Exception(String.format("Veuillez reformuler %s", cle));
    }

    public static String prompt(String req) {
        System.out.printf("%s", req);
        return sc.nextLine();
    }

    public static String prompt(String req, String regexp) throws Exception {
        System.out.printf("%s", req);
        var input = sc.nextLine();

        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(input).find())
            return input;
        
        throw new Exception("Veuillez réssayer, en reformulant votre input.");
    }

    public static void ajouterCommande(String commande, Runnable methode) {
        commandes.put(commande, methode);
    }

    public static void loop() {
        for(;;) {
            System.out.printf("Choisir commande %s: ", commandes.keySet());
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
