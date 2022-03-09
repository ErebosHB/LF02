import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        if (gegenstandsliste.contains(gegenstand.getId())) {
            gegenstandsliste.remove(gegenstand);
        }
        else {
            throw new KeineIdException(gegenstand.getId());
        }
    }

    public double ermittelGesamtwert() {
        double gesamtwert = 0;
        for (Gegenstand j : gegenstandsliste) {

            gesamtwert += j.getWert();
        }
        return gesamtwert;
    }

    @Override
    public String toString() {
        return "Gegenstände im Tresor:\n"+getGegenstandsliste()+
                "\nGesamtwert aller Gegenstände: "+ermittelGesamtwert();
    }
}
