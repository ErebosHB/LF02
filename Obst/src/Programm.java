public class Programm {

    public static void main(String[] args) {

        Apfel apfel = new Apfel();

        apfel.setFarbe("grün");
        apfel.setGewicht(250);

        apfel.setReife(true);

        System.out.println("der Apfel ist " + apfel.getFarbe());
        System.out.println("Der Apfel wiegt " + apfel.getGewicht() + "g");
        System.out.println("der Apfel heißt " + apfel.getName());

        Apfel apfel2 = new Apfel();

        apfel2.setFarbe("rot");
        apfel2.setGewicht(200);

        apfel2.setReife(false);

        System.out.println("der Apfel ist " + apfel2.getFarbe());
        System.out.println("Der Apfel wiegt " + apfel2.getGewicht() + "g");
        System.out.println("der Apfel heißt " + apfel2.getName());

        Banane banane = new Banane();
        System.out.println(banane.getName());
    }
}
