package io.brinim.courriers;

import io.brinim.courriers.enums.TypeCourrier;

public class Main {
    static Poste p = new Poste();
    public static void main(String[] args) {
        Menu.ajouterCommande("Ajouter", Main::initializeCourrier);
        Menu.ajouterCommande("Afficher", () -> System.out.println(p));
        Menu.ajouterCommande("Exit", () -> System.exit(0));

        Menu.loopAsync();
    }

    private static void initializeCourrier() {
        try {
            var adresseExp = Menu.question("adresse d'expédition");
            var adresseDest = Menu.question("adresse destination");
            var poid = Menu.question("poid", "en grammes, ex: 15", "^[0-9]+$");
            var type = Menu.question("Type courrier", TypeCourrier.class);

            p.ajouterCourrier(adresseExp, adresseDest, Integer.parseInt(poid), (TypeCourrier)type);
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
