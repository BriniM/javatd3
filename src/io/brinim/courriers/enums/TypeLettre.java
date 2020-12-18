package io.brinim.courriers.enums;

public enum TypeLettre {
    ORDINAIRE, PRIORITAIRE, PETITE_FORMAT, MOYEN_FORMAT, GRAND_FORMAT;

    public String toString() {
        switch (this) {
            case ORDINAIRE:
                return "Ordinaire";
            case PRIORITAIRE:
                return "Prioritaire";
            case PETITE_FORMAT:
                return "Petite format";
            case MOYEN_FORMAT:
                return "Format moyen";
            case GRAND_FORMAT:
                return "Grand format";
            default:
                System.out.println("Taille lettre inconnu.");
                return null;
        }
    }

    /**
     * Fonction extensible qui retourne les Proprietes d'une lettre (prix, poid min, poid max).
     * Par ex: on peut remplacer les valeurs hard coded par un appel a une BDD.
     * @return ProprietesLettre
     */
    public ProprietesLettre getTypeLettre() {
        switch (this) {
            case ORDINAIRE:
                return new ProprietesLettre(0.25, 0, 20);
            case PRIORITAIRE:
                return new ProprietesLettre(0.39, 0, 20);
            case PETITE_FORMAT:
                return new ProprietesLettre(0.7, 20, 250);
            case MOYEN_FORMAT:
                return new ProprietesLettre(1.5, 250, 1000);
            case GRAND_FORMAT:
                return new ProprietesLettre(2.3, 1000, 2000);
            default:
                System.out.println("Taille lettre inconnu.");
                return null;
        }
    }
}
