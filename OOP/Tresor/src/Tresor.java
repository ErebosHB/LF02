
import java.util.ArrayList;

public class Tresor {
    private ArrayList<Gegenstand> gegenstandsliste;


    public Tresor(ArrayList<Gegenstand> gegenstandsliste) {
        this.gegenstandsliste = gegenstandsliste;
    }

    public ArrayList<Gegenstand> getGegenstandsliste() {
        return gegenstandsliste;
    }

    public void addGegenstand(Gegenstand gegenstand) {
        gegenstandsliste.add(gegenstand);
    }

    public void removeGegenstand(Gegenstand gegenstand) throws KeineIdException{
        if (gegenstandsliste.contains(gegenstand)) {
            gegenstandsliste.remove(gegenstand);
            System.out.println("Gegenstand mit der ID "+gegenstand.getId()+" wurde aus dem Tresor entfernt.\n");
        }
        else {
            throw new KeineIdException(gegenstand.getId());
        }
    }

    public double berechneGesamtwert() {
        double gesamtwert = 0;
        for (Gegenstand j : gegenstandsliste) {

            gesamtwert += j.getWert();
        }
        return gesamtwert;
    }

    @Override
    public String toString() {
        return "Gegenstände im Tresor:\n"+getGegenstandsliste()+
                "\nGesamtwert aller Gegenstände: "+berechneGesamtwert();
    }
}
