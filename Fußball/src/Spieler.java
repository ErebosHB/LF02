public class Spieler {

    private String name;
    private int alter;
    private int staerke;
    private int torschuss;
    private int motivation;
    private int tore;

    public Spieler(String name){
        this.name = name;
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

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public int getStaerke() {
        return staerke;
    }

    public void setTorschuss(int torschuss) {
        this.torschuss = torschuss;
    }

    public int getTorschuss() {
        return torschuss;
    }

    public void setMotivation(int motivation) {
        this.motivation = motivation;
    }

    public int getMotivation() {
        return motivation;
    }

    public void setTore(int tore) {
        this.tore = tore;
    }

    public int getTore() {
        return tore;
    }

    @Override
    public String toString(){
        String text = "\tName\t\t= "+name;
        text += "\n\tAlter\t\t= "+alter;
        text += "\n\tStärke\t\t= "+staerke;
        text += "\n\tTorschuss\t= "+torschuss;
        text += "\n\tMotivation\t= "+motivation;
        text += "\n\tTore\t\t= "+tore;

        return text;

    }
}
