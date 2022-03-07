import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tresor {
    private ArrayList<Gegenstand> gegenstandsliste;
    private double gesamtwert;

    public Tresor(ArrayList<Gegenstand> gegenstandsliste){
        this.gegenstandsliste = gegenstandsliste;
    }

    public ArrayList<Gegenstand> getGegenstandsliste() {
        return gegenstandsliste;
    }

    public void setGegenstandsliste(ArrayList<Gegenstand> gegenstandsliste) {
        this.gegenstandsliste = gegenstandsliste;
    }

    public double gesamtwert(ArrayList<Gegenstand> gegenstandsliste){
        for (Gegenstand i : gegenstandsliste
             ) {

            gesamtwert += i.getWert();
        }
        return gesamtwert;
    }

    public Gegenstand ermittelGegenstand(ArrayList<Gegenstand> gegenstandsliste) throws IOException {
        System.out.println("Bitte geben Sie die ID ein, die Sie suchen.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String eingabe = br.readLine();
        int objekt = 0;
        for (Gegenstand i : gegenstandsliste
        ) {
            if (eingabe == gegenstandsliste.get(objekt).getId()) {
                System.out.println("Dieser Gegenstand ist im Tresor");
                return gegenstandsliste.get(objekt);
            }
            objekt++;
        }
        if (eingabe != gegenstandsliste.get().getId()){

    }

}
