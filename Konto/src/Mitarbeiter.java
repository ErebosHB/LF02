public class Mitarbeiter extends Person{
    public Mitarbeiter(String vorname, String nachname){
        super(vorname,nachname);
    }

    @Override
    public String toString() {
        return "\nBetreuer"+
                "\nVorname: "+getVorname()+
                "\nNachname: "+getNachname()+"\n";

    }
}
