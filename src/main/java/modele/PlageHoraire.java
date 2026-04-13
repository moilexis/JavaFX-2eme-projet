package modele;

public class PlageHoraire implements Comparable <PlageHoraire> {
     private static final int dureeMin = 30;
     private Horaire horaireDebut;
     private Horaire horaireFin;

     public PlageHoraire( Horaire debut, Horaire fin){
         horaireDebut = debut;
         horaireFin = fin;
     }
     public Horaire duree(){
         if (estValide()){
             int diff = horaireFin.toMinutes() - horaireDebut.toMinutes();
             return new Horaire(diff/60,diff%60);
         }
         return null;
     }
     public boolean estValide(){
         return (horaireFin.toMinutes() - horaireDebut.toMinutes() >= dureeMin && horaireDebut.estValide() && horaireFin.estValide());
     }

    public int compareTo(PlageHoraire ph){
         if (horaireFin.toMinutes()<ph.horaireDebut.toMinutes()){
             return -1;
         } else if (ph.horaireFin.toMinutes() < horaireDebut.toMinutes()) {
             return 1;
         }
         return 0;
    }


     public Horaire getHoraireDebut(){
         return horaireDebut;
     }
     public Horaire getHoraireFin(){
         return horaireFin;
     }
     public int getDureeMin(){
         return dureeMin;
     }
     public void setHoraireDebut(Horaire debut){
         horaireDebut = debut;
     }
     public void setHoraireFin(Horaire fin){
         horaireFin = fin;
     }

     public String toString(){
         return horaireDebut+ " - " + horaireFin + ", durée : "+duree();
     }
}
