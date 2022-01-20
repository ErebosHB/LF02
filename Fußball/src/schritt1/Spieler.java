package schritt1;

import schritt3.Person;

public class Spieler extends Person {


    private int staerke;
    private int torschuss;
    private int motivation;
    private int tore;

    public Spieler(String name,int alter,int staerke, int torschuss, int motivation, int tore){
        super(name,alter);
        this.staerke = staerke;
        this.torschuss = torschuss;
        this.motivation = motivation;
        this.tore = tore;
    }



    public int getStaerke() {
        return staerke;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public int getTorschuss() {
        return torschuss;
    }

    public void setTorschuss(int torschuss) {
        this.torschuss = torschuss;
    }

    public int getMotivation() {
        return motivation;
    }

    public void setMotivation(int motivation) {
        this.motivation = motivation;
    }

    public int getTore() {
        return tore;
    }

    public void setTore(int tore) {
        this.tore = tore;
    }



    @Override
    public String toString(){
        String text = "\tName\t\t= "+getName();
        text += "\n\tAlter\t\t= "+getAlter();
        text += "\n\tStärke\t\t= "+staerke;
        text += "\n\tTorschuss\t= "+torschuss;
        text += "\n\tMotivation\t= "+motivation;
        text += "\n\tTore\t\t= "+tore;

        return text;

    }
}
