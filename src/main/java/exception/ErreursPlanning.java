package exception;

public enum ErreursPlanning {
    RESERVATION_NON_VALIDE,PLANNING_PLEIN,RESERVATION_INCOMPATIBLE;
    public String toString(){
        switch (this){
            case RESERVATION_NON_VALIDE: return "cette reservation n'est pas valide, on le l'ajoute pas au planning";
            case PLANNING_PLEIN: return "il  n'a pas de place dans le planning, veuillez faire de la place";
            default: return "la réservation est incompatible";
        }
    }
}