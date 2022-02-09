public class Programm {
    public static void main(String[] args) {
        Elfe elfe1 = new Elfe("Tom",6);
        Zauberer zauberer1 = new Zauberer("Lehrling",7,5);

        try {
            System.out.println(elfe1);
            elfe1.rennen();
            elfe1.laufen();
            System.out.println(elfe1);

        }catch (KeineKraftException e){
            System.out.println(e.getMessage());
        }
        System.out.println("===================================");
        try {
            System.out.println(zauberer1);
            zauberer1.zaubern();
            System.out.println(zauberer1);

        }catch (KeineKraftException e){
            System.out.println(e.getMessage());
        }


    }
}
