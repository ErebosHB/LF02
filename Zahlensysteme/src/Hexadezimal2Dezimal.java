import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hexadezimal2Dezimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bitte geben Sie ihre Hexadezimalzahl ein:");
        String hexa = br.readLine();
        String b1 = new StringBuilder(hexa).reverse().toString();
        String[] parts = b1.split("");
        int[] deziEinz = new int[parts.length];
        int dezimal = 0;
        int zwisch;
        int[] zahl = new int[parts.length];
        zahl[0] = 1;
        zahl[1] = 16;
        for (int j = 2;j < zahl.length; j++){
            zahl[j] = zahl[j-1]*zahl[1];
        }
        for (int i = 0; i < zahl.length; i++) {
            if (parts[i].equals("A") || parts[i].equals("B") || parts[i].equals("C") || parts[i].equals("D") || parts[i].equals("E") || parts[i].equals("F")) {
                switch (parts[i]) {
                    case "A":
                        parts[i] = "10";
                        zwisch = Integer.parseInt(parts[i]);
                        deziEinz[i] = zahl[i] * zwisch;
                        break;
                    case "B":
                        parts[i] = "11";
                        zwisch = Integer.parseInt(parts[i]);
                        deziEinz[i] = zahl[i] * zwisch;
                        break;
                    case "C":
                        parts[i] = "12";
                        zwisch = Integer.parseInt(parts[i]);
                        deziEinz[i] = zahl[i] * zwisch;
                        break;
                    case "D":
                        parts[i] = "13";
                        zwisch = Integer.parseInt(parts[i]);
                        deziEinz[i] = zahl[i] * zwisch;
                        break;
                    case "E":
                        parts[i] = "14";
                        zwisch = Integer.parseInt(parts[i]);
                        deziEinz[i] = zahl[i] * zwisch;
                        break;
                    case "F":
                        parts[i] = "15";
                        zwisch = Integer.parseInt(parts[i]);
                        deziEinz[i] = zahl[i] * zwisch;
                        break;
                }
            } else {
                zwisch = Integer.parseInt(parts[i]);
                if (zwisch < 10) {
                    deziEinz[i] = zahl[i] * zwisch;
                }

            }
            dezimal = dezimal + deziEinz[i];
            if (i == zahl.length-1){
                System.out.println("Die Dezimalzahl lautet: " + dezimal);
            }
        }


    }
}
