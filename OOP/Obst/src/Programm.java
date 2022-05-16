public class Programm {

    public static void main(String[] args) {

        Apfel apfel = new Apfel();

        apfel.setFarbe("grün");
        apfel.setGewicht(250);
        apfel.setReife(true);

        Banane banane = new Banane();

        banane.setFarbe("gelb");
        banane.setGewicht(300);
        banane.setReife(true);
        banane.setKruemmung(5);




        System.out.println(banane);

        System.out.println();

        System.out.println(apfel);
    }
}
