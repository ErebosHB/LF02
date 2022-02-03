package schritt4;

public class Ergebnis {
    private int trefferheim;
    private int treffergast;


    public int getTreffergast() {
        return treffergast;
    }

    public int getTrefferheim() {
        return trefferheim;
    }

    public void setTrefferHeim() {
        trefferheim++;
    }

    public void setTrefferGast() {
        treffergast++;
    }

    @Override
    public String toString() {
        return "\nHeim: " + getTrefferheim()+
        "\nGast: " + getTreffergast();
            }
}
