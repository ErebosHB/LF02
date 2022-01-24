package schritt4;

import schritt1.Spieler;
import schritt1.Trainer;
import schritt2.Torwart;

import java.util.ArrayList;

public class Mannschaft {
    String name;
    Trainer trainer;
    Torwart torwart;
    int motivation;
    int motivationsdurchschnitt;
    ArrayList<Spieler>spielerListe;
    int staerke;
    int staerkedurchschnitt;

    public Mannschaft(String name, Trainer trainer, Torwart torwart, ArrayList spielerListe) {
        this.name = name;
        this.trainer = trainer;
        this.torwart = torwart;
        this.spielerListe = spielerListe;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Torwart getTorwart() {
        return torwart;
    }

    public void setTorwart(Torwart torwart) {
        this.torwart = torwart;
    }

    public ArrayList<Spieler> getSpielerListe() {
        return spielerListe;
    }

    public void setSpielerListe(ArrayList<Spieler> spielerListe) {
        this.spielerListe = spielerListe;
    }

    public int getMotivation() {

        for (Spieler i : spielerListe
        ) {
            motivation += i.getMotivation();
        }
        motivation += torwart.getMotivation();
        motivationsdurchschnitt = motivation / (spielerListe.size() + 1);
        return motivationsdurchschnitt;
    }

    public int getStaerke() {

        for (Spieler i : spielerListe
        ) {
            staerke += i.getStaerke();
        }
        staerke += torwart.getStaerke();
        staerkedurchschnitt = staerke / (spielerListe.size() + 1);
        return staerkedurchschnitt;


    }

    @Override
    public String toString() {
        String text = "\nName = "+name+"\n";
        text +="\nTrainer =\n "+trainer;
        text +="\nTorwart = "+torwart;
        text +="\nSpieler = "+getSpielerListe();
        text +="\n\nMotivationsdurchschnitt\t= "+getMotivation();
        text +="\nStärkedurchschnitt\t\t= " + getStaerke() ;
        return text;
    }
}

