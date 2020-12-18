package io.brinim.courriers;

public class Main {
    static Poste p = new Poste();
    public static void main(String[] args) {
        Menu.ajouterCommande("Ajouter", () -> {
            var type = Menu.question("Type courrier", "Lettre/Colis");
            var adresseExp = Menu.question("adresse d'expedition");
            var adresseDest = Menu.question("adresse destination");
            var poid = Integer.parseInt(Menu.question("le poid", "en grammes"));

            if (type.equalsIgnoreCase("colis"))
                p.getCourriers().add(new Colis(adresseDest, adresseExp, poid));
            else if(type.equalsIgnoreCase("lettre"))
                p.getCourriers().add(new Lettre(adresseDest, adresseExp, poid));
            else
                System.out.println("Type inconnu");
        });

        Menu.ajouterCommande("Afficher", () -> {
            System.out.println(p);
        });

        Menu.loopAsync();
    }
}
