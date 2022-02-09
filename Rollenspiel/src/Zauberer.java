public class Zauberer extends Spielfigur{
    private int zauberpunkte;
    public Zauberer(String name,int staerkepunkte,int zauberpunkte){
        super(name,staerkepunkte);
        this.zauberpunkte = zauberpunkte;
    }

    public int getZauberpunkte() {
        return zauberpunkte;
    }
    public void trinkenZaubertrank(){
        zauberpunkte += 3;
        System.out.println(getName()+" trinkt Zaubertrank(+3 Zauberpunkte)");
    }
    public void zaubern() throws KeineKraftException{
        zauberpunkte -= 1;
        if (fehler1(zauberpunkte)){
            throw new KeineKraftException(getName(),"zaubern");
        }
        else {
            System.out.println(getName()+" zaubert(-1 Zauberpunkt)");
        }
    }
    public static boolean fehler1(int zauberpunkte){
        boolean ok;
        if (zauberpunkte < 1){
            ok = true;
        }else {
            ok = false;
        }
        return ok;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nZauberpunkte: "+zauberpunkte;
    }
}
