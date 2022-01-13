public class Banane extends Obst {

    private double kruemmung;

    public Banane() {
        super("banane");
    }

    public double getkruemmung(){
        return kruemmung;
    }

    public void setKruemmung(double kruemmung){
        this.kruemmung = kruemmung;
    }

}
