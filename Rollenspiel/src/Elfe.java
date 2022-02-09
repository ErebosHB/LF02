public class Elfe extends Spielfigur{
    public Elfe(String name,int staerkepunkte){
        super(name,staerkepunkte);
    }
    public void rennen() throws KeineKraftException{
        setStaerkepunkte(getStaerkepunkte()-2);
        if (Spielfigur.fehler(getStaerkepunkte())){
            throw new KeineKraftException(getName(),"rennen");
        }
        else {
            System.out.println(getName()+" rennt(-2 Stärkepunkte)");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
