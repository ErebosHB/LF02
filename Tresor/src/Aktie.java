public class Aktie extends Gegenstand{
    private String name;
    private double nennwert;

    public Aktie(int id, double wert, String name, double nennwert){
        super(id, wert);
        this.name = name;
        this.nennwert = nennwert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNennwert() {
        return nennwert;
    }

    public void setNennwert(double nennwert) {
        this.nennwert = nennwert;
    }

    @Override
    public String toString() {
        return super.toString()+"Firmenname\t: "+getName()+"\n"+
                "Nennwert\t: "+getNennwert()+"\n\n";
    }
}
