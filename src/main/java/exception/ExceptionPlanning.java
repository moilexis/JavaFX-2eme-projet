package exception;

public class ExceptionPlanning extends Exception {
    private ErreursPlanning erreur;

    public ExceptionPlanning(ErreursPlanning erreursPlanning) {
        erreur = erreursPlanning;
    }
    public String getMessage(){

        return erreur.toString();
    }

}
