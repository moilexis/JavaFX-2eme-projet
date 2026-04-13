package modele;

public class Reservation implements Comparable <Reservation> {
    private DateCalendrier date;
    private PlageHoraire plage;
    private String intitule ;

    public Reservation(DateCalendrier parDate, PlageHoraire parPlage, String parIntitule) {
        date = parDate;
        plage = parPlage;
        intitule = parIntitule;
    }
    public boolean estValide () {
        return (date.estValide() && plage.estValide());
    }

    public int compareTo(Reservation resa) {
        if(date.compareTo(resa.date) == 0){
            return plage.compareTo(resa.plage);
        }
        return date.compareTo(resa.date);
    }
    public DateCalendrier getDate() {
        return date;}
    public PlageHoraire getPlage() {
        return plage;}
    public String getIntitule() {
        return intitule;}
    public String toString() {
        return intitule+ " le "+ date + " entre " + plage;
    }

}
