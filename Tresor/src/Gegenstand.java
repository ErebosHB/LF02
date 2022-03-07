public abstract class Gegenstand {
    private String id;
    private double wert;

    public Gegenstand(String id, double wert){
        this.id = id;
        this.wert = wert;
    }

    public String getId() {
        return id;
    }

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }

    @Override
    public String toString() {
        return "ID\t\t: "+getId()+"\n"+
                "Gegenstandswert\t: "+getWert()+"\n";
    }
}
