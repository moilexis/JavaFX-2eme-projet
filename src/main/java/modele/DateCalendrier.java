package modele;

import java.util.Calendar;
public class DateCalendrier extends Date
        implements Comparable <Date>{
    public int jourSemaine;
    public int semaineAnnee;

    public DateCalendrier() {
        Calendar today = Calendar.getInstance();
        annee = today.get(Calendar.YEAR);
        mois = today.get(Calendar.MONTH)+1;
        jour = today.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        jourSemaine = (dayOfWeek +6)%7;
        if (jourSemaine== 0){
            jourSemaine = 7;
        }
        jourSemaine = today.get(Calendar.WEEK_OF_YEAR);
    }
    public DateCalendrier(int parJour, int parMois, int parAnnee) {
        super(parJour, parMois, parAnnee);
        Calendar jourConcerne = Calendar.getInstance() ;
        jourConcerne.set(parAnnee,parMois-1,parJour);
        //System.out.println("jourConcerne : " + parJour + " " + parMois + " " + parAnnee);

        int dayOfWeek = jourConcerne.get(Calendar.DAY_OF_WEEK);
        //System.out.println("dayOfWeek : " + dayOfWeek);

        jourSemaine = (dayOfWeek +6)%7;
        if (jourSemaine== 0){
            jourSemaine = 7;
        }
        //System.out.println("jourSemaine corrigé: " + jourSemaine);
        semaineAnnee = jourConcerne.get(Calendar.WEEK_OF_YEAR);
    }
    public int getJourSemaine() {
        return jourSemaine;
    }
    @Override
    public DateCalendrier dateDuLendemain(){
        Date lendemain = super.dateDuLendemain();
        return new DateCalendrier(lendemain.jour, lendemain.mois,lendemain.annee);
    }
    public DateCalendrier dateDeLaVeille(){
        Date veille = super.dateDeLaVeille();
        return new DateCalendrier(veille.jour, veille.mois, veille.annee);
    }
    /**renvoie le nom du jour en chaine de caracrtère à l'indice jour_nbr
     *
     * @param jour_nbr, l'indice du jour de la semaine, 1 pour lundi, 2 pour mardi...
     * @return le mot écrit, Lundi, Mardi...
     */
    public static String jour_en_mot (int jour_nbr){
        switch (jour_nbr) {
            case 1:
                return "Lundi";
            case 2:
                return "Mardi";
            case 3:
                return "Mercredi";
            case 4:
                return "Jeudi";
            case 5:
                return "Vendredi";
            case 6:
                return "Samedi";
            default:
                return "Dimanche";
        }
    }

    /**renvoie le nom du moid en chaine de caracrtère à l'indice mois_nbr
     *
     * @param mois_nbr, l'indice du mois, 1 pour janvier, 2 pour fevrier...
     * @return le mot écrit, janvier, fevrier...
     */
    public static String mois_en_mot (int mois_nbr){
        switch (mois_nbr) {
            case 1:return "Janvier";
            case 2:return "Fevrier";
            case 3:return "Mars";
            case 4:return "Avril";
            case 5:return "Mai";
            case 6:return "Juin";
            case 7:return "Juillet";
            case 8:return "Aout";
            case 9:return "Septembre";
            case 10:return "Octobre";
            case 11:return "Novembre";
            default:return "Decembre";
        }

    }
    public String toString() {
        String jour_mot = jour_en_mot (jourSemaine);
        String mois_mot = mois_en_mot (mois);

        return jour_mot +" "+ jour +" "+mois_mot +" "+ annee;
    }
}
