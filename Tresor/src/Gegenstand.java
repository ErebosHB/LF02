public abstract class Gegenstand {
    private final int id;
    private double wert;

    public Gegenstand(int id, double wert){
        this.id = id;
        this.wert = wert;
    }

    public int getId() {
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
        return "\nID\t\t: "+getId()+"\n"+
                "Gegenstandswert\t: "+getWert()+"\n";
    }
}
