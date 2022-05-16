public abstract class Spielfigur {
    private String name;
    private int staerkepunkte;

    public Spielfigur(String name,int staerkepunkte){
        this.name = name;
        this.staerkepunkte = staerkepunkte;
    }

    public String getName() {
        return name;
    }

    public int getStaerkepunkte() {
        return staerkepunkte;
    }

    protected void setStaerkepunkte(int staerkepunkte) {
        this.staerkepunkte = staerkepunkte;
    }
    public void essen(){
        staerkepunkte += 10;
        System.out.println(name+" isst(+10 Stärkepunkte)");
    }
    public void laufen() throws KeineKraftException{
        staerkepunkte -= 1;
        if (fehler(staerkepunkte)){
            throw new KeineKraftException(name,"laufen");
        }
        else {
            System.out.println(name+" läuft(-1 Stärkepunkt)");
        }
    }
    public void klettern() throws KeineKraftException{
        staerkepunkte -= 2;
        if (fehler(staerkepunkte)){
            throw new KeineKraftException(name,"klettern");
        }
        else {
            System.out.println(name+" klettert(-1 Stärkepunkt)");
        }
    }
    public void kaempfen() throws KeineKraftException{
        staerkepunkte -= 3;
        if (fehler(staerkepunkte)){
            throw new KeineKraftException(name,"kämpfen");
        }
        else {
            System.out.println(name+" kämpft(-3 Stärkepunkte)");
        }
    }
    public static boolean fehler(int staerkepunkte){
        boolean ok;
        if (staerkepunkte < 1){
            ok = true;
        }else {
            ok = false;
        }
        return ok;
    }

    @Override
    public String toString() {
        return "\nName: "+name+
                "\nStärkepunkte: "+staerkepunkte;
    }
}
