package schritt1;

import schritt3.Person;

public class Trainer extends Person {


    private double erfahrung;

    public Trainer(String name, int alter, double erfahrung){
        super(name,alter);
        this.erfahrung = erfahrung;
    }



    public double getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(double erfahrung) {
        this.erfahrung = erfahrung;
    }



    @Override
    public String toString(){
        String text = "\tName\t\t= "+getName();
        text += "\n\tAlter\t\t= "+getAlter();
        text += "\n\tErfahrung\t= "+erfahrung;
        return text;
    }
}

