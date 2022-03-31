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
        int deziEinz = 0;
        int dezimal = 0;
        int zwisch;
        int[] zahl = new int[parts.length+1];

        for (int i = 0; i < zahl.length; i++){
            zahl[0] = 1;
            zahl[1] = 16;
            if (parts[i].equals("A") || parts[i].equals("B") || parts[i].equals("C") || parts[i].equals("D") || parts[i].equals("E") || parts[i].equals("F")){
                if (parts[i].equals("A")){
                    parts[i] = "10";
                    zwisch = Integer.parseInt(parts[i]);
                    deziEinz = zahl[i]*zwisch;
                }
                if (parts[i].equals("B")){
                    parts[i] = "11";
                    zwisch = Integer.parseInt(parts[i]);
                    deziEinz = zahl[i]*zwisch;
                }
                if (parts[i].equals("C")){
                    parts[i] = "12";
                    zwisch = Integer.parseInt(parts[i]);
                    deziEinz = zahl[i]*zwisch;
                }
                if (parts[i].equals("D")){
                    parts[i] = "13";
                    zwisch = Integer.parseInt(parts[i]);
                    deziEinz = zahl[i]*zwisch;
                }
                if (parts[i].equals("E")){
                    parts[i] = "14";
                    zwisch = Integer.parseInt(parts[i]);
                    deziEinz = zahl[i]*zwisch;
                }
                if (parts[i].equals("F")){
                    parts[i] = "15";
                    zwisch = Integer.parseInt(parts[i]);
                    deziEinz = zahl[i]*zwisch;
                }
            }
            else {
                zwisch = Integer.parseInt(parts[i]);
                if (zwisch < 10){
                    deziEinz = zahl[i]*zwisch;
                }

            }
            System.out.println(deziEinz);
            dezimal = dezimal + deziEinz;
            zahl[i+1] = zahl[i]*16;
        }
        System.out.println("Die Dezimalzahl lautet: "+dezimal);
    }
}
