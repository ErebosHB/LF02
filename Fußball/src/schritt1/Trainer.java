package schritt1;

import schritt3.Person;

public class Trainer extends Person {


    private int erfahrung;

    public Trainer(String name, int alter, int erfahrung){
        super(name,alter);
        this.erfahrung = erfahrung;
    }



    public int getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }



    @Override
    public String toString(){
        String text = "\n\tName\t\t= "+getName();
        text += "\n\tAlter\t\t= "+getAlter();
        text += "\n\tErfahrung\t= "+erfahrung+"\n";
        return text;
    }
}

