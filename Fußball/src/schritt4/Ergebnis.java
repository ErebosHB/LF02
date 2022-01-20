package schritt4;

public class Ergebnis {
    private int trefferheim;
    private int treffergast;
    int punkteh;
    int punkteg;

    public int getTreffergast() {
        return treffergast;
    }

    public int getTrefferheim() {
        return trefferheim;
    }

    public int TrefferHeim(){
        trefferheim += 1;
        punkteh += trefferheim;
        return punkteh;
    }

    public int TrefferGast(){
        treffergast += 1;
        punkteg += treffergast;
        return punkteg;
    }

    @Override
    public String toString() {
        return super.toString()+"Endergebnis"+"\n"+"Heim : "+punkteh+"\n"+"Gast : "+punkteg;
    }
}
