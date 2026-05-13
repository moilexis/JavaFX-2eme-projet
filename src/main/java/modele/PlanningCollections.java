package modele;

import exception.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class PlanningCollections {
    private ArrayList<Reservation> listeResa;
    private TreeSet<Reservation> treeResa;
    private TreeMap<Integer, ArrayList<Reservation> > mapResa;

    public PlanningCollections() {
        listeResa = new ArrayList<>();
        treeResa = new TreeSet<>();
        mapResa = new TreeMap<>();
    }
    public void ajout (Reservation resa) throws ExceptionPlanning {
        if (!resa.estValide()){
            throw new ExceptionPlanning(ErreursPlanning.RESERVATION_NON_VALIDE);}
        else  {
            for (Reservation reservation : listeResa) {// équivalent à (int i=0;i<listeResa.size();i++)
                if (reservation.compareTo(resa) == 0) {
                    throw new ExceptionPlanning(ErreursPlanning.RESERVATION_INCOMPATIBLE);
                }
            }
            listeResa.add(resa);
            Iterator<Reservation> itr_tree = treeResa.iterator();
            while (itr_tree.hasNext()){
                if (itr_tree.next().compareTo(resa)==0){
                    throw new ExceptionPlanning(ErreursPlanning.RESERVATION_INCOMPATIBLE);
                }
            }

            treeResa.add(resa);
            mapResa.putIfAbsent(resa.getDate().getWeekOfYear(), new ArrayList<Reservation>());
            mapResa.get(resa.getDate().getWeekOfYear()).add(resa);
        }
    }

    /**cherche les reservations à la date passée en paramètre dans this PlanningCollections
     * Renvoie l'ensemble des resservations concernées s'il y en a, null sinon
     *
     * @param parDate une DateCalendrier
     * @return l'ensemble contenant toutes les reservations de la date
     */
    public TreeSet<Reservation> getReservations(DateCalendrier parDate) {
        TreeSet<Reservation> setRetour = new TreeSet<>();
        for (Reservation resa : listeResa) {
            if (resa.getDate().compareTo(parDate)==0){
                setRetour.add(resa);
            }
        }
        if (setRetour.isEmpty()){
            return null;}
        return setRetour;
    }

    /** Cherche et renvoie les reservations de this dont l'intitulé contient la chaine
     * s'ils existent, null sinon.
     *
     * @param chaine le motif à chercher dans les intitulés
     * @return
     */
    public TreeSet<Reservation> getReservations(String chaine) {
        TreeSet<Reservation> setRetour = new TreeSet<>();
        for (Reservation resa : listeResa) {
            if (resa.getIntitule().contains(chaine)){
                setRetour.add(resa);
            }
        }
        if (setRetour.isEmpty()){
            return null;}
        return setRetour;
    }

    @Override
    public String toString() {
        return "taille de la liste : " + listeResa.size()+"\n élements : \n"+listeResa +
                "################################################################################"+
                "\n taille de l'ensemble : " + treeResa.size()+"\n élements : \n"+treeResa +"\n"+
                "################################################################################"+
                "\n la TreeMap des semaines contient : " +  mapResa.toString()+"\n";

    }
}
