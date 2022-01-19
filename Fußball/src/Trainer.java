public class Trainer {

    private String name;
    private int alter;
    private double erfahrung;

    public Trainer(String name, int alter, double erfahrung){
        this.name = name;
        this.alter = alter;
        this.erfahrung = erfahrung;
    }

    public String getName() {
        return name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public int getAlter() {
        return alter;
    }

    public void setErfahrung(double erfahrung) {
        this.erfahrung = erfahrung;
    }

    public double getErfahrung() {
        return erfahrung;
    }

    @Override
    public String toString(){
        String text = "\tName\t\t= "+name;
        text += "\n\tAlter\t\t= "+alter;
        text += "\n\tErfahrung\t= "+erfahrung;
        return text;
    }
}

