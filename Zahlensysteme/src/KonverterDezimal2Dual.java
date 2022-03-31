public class KonverterDezimal2Dual {
    public static void main(String[] args){
        int dezimal = 2034;
        int schritt = dezimal;
        String binaer ="";
        while (schritt>=1){
            binaer = String.valueOf(schritt%2);
            String b1 = new StringBuilder(binaer).reverse().toString();
            System.out.print(b1);
            schritt = schritt/2;
        }

    }
}
