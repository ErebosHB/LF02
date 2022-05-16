import java.util.ArrayList;

public class Programm {
    public static void main(String[] args) {
        ArrayList<Gegenstand> gegenstaende = new ArrayList<>();
        Schmuck kette = new Schmuck(1111,299.99,"Kette");
        Aktie aktie1 = new Aktie(2222,99.99,"Mercedes",2.3);
        Aktie aktie2 = new Aktie(3333,99.99,"BMW",2.3);

        Tresor tresor = new Tresor(gegenstaende);

        try {
            tresor.addGegenstand(kette);
            tresor.addGegenstand(aktie1);
            System.out.println(tresor);
            tresor.removeGegenstand(aktie1);
            System.out.println(tresor);

        }catch (KeineIdException e){
            System.out.println(e.getMessage());
        }

    }
}
