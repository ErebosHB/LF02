public abstract class Obst {

    private String name;
    private double gewicht;
    private String farbe;
    private boolean reife;

    //Konstruktor
    public Obst(String name) {
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public boolean isReife() {
        return reife;
    }

    public void setReife(boolean reife) {
        this.reife = reife;
    }


}


