package io.brinim.courriers;

public class Main {
    static Poste p = new Poste();
    public static void main(String[] args) {
        Menu.ajouterCommande("Ajouter", () -> {
            // Problem: User input is getting out of control: repetitive code, can I make it iterative?
            // A solution I used in the past was to throw IllegalArgumentExceptions however, I'm interested
            // in making my code bullet proof and DRY (Don't repeat yourself).

            // Another problem caused by the above issue: Huge main method, ideally,
            // Methods should be 20 lines for it to be readable.
            // Why? This method is taking the shore of doing more than one task at once
            // 1: Taking input
            // 2: verifying the input
            // 3: Constructing objects.

            // Improvement: verify input in the Menu class via a regex passed as parameter.
            // Possible solution: getDeclaredFields on [Class]
            var type = Menu.question("Type courrier", "Lettre/Colis");
            boolean lettreEstOrdinaire = false;

            if (type.equalsIgnoreCase("lettre")) {
                var estOrdinaire = Menu.prompt("La lettre est ordinaire? (Oui/Non)");

                if (estOrdinaire.equalsIgnoreCase("oui")) {
                    lettreEstOrdinaire = true;
                } else if (!estOrdinaire.equalsIgnoreCase("non")) {
                    System.out.println("Veuillez entrer oui ou non pour specifier si la letter est ordinaire.");
                    return;
                }
            } else if (!type.equalsIgnoreCase("colis")) {
                System.out.println("Le type doit être soit Colis ou Lettre");
                return;
            }

            var adresseExp = Menu.question("adresse d'expédition");
            var adresseDest = Menu.question("adresse destination");
            var poid = Menu.question("le poid", "en grammes");

            if (!poid.matches("^[0-9]+$")) {
                System.out.println("Le poid doit avoir une valeur numérique.");
                return;
            }

            if (type.equalsIgnoreCase("colis"))
                p.getCourriers().add(new Colis(adresseDest, adresseExp, Integer.parseInt(poid)));
            else if(type.equalsIgnoreCase("lettre"))
                p.getCourriers().add(new Lettre(adresseDest, adresseExp, Integer.parseInt(poid), lettreEstOrdinaire));
            else
                System.out.println("Type inconnu");
        });

        Menu.ajouterCommande("Afficher", () -> System.out.println(p));
        Menu.ajouterCommande("Exit", () -> System.exit(0));

        Menu.loopAsync();
    }
}
