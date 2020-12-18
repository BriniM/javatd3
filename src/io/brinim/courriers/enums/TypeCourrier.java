package io.brinim.courriers.enums;

public enum TypeCourrier {
    COLIS, LETTRE;

    public String toString() {
        switch (this) {
            case COLIS: return "Colis";
            case LETTRE: return "Lettre";
            default: return "Unknown";
        }
    }
}
