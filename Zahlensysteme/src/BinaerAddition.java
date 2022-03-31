import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaerAddition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Wie viele Stellen haben die Binärzahlen maximal?");
        int laenge = Integer.parseInt(br.readLine());
        int[] array1 = new int[laenge + 1];
        System.out.println("Bitte gib die ertse ziffernweise von rechts ein: ");
        for (int i = 0; i < array1.length - 1; i++) {
            array1[i] = Integer.parseInt(br.readLine());
            if (array1[i] != 0 && array1[i] != 1) {
                System.out.println("Bitte richtig eingeben");
                i--;
            }
        }
        array1[array1.length - 1] = 0;
        int[] array2 = new int[laenge + 1];
        System.out.println("Bitte gib die zweite ziffernweise von rechts ein: ");
        for (int i = 0; i < array2.length - 1; i++) {
            array2[i] = Integer.parseInt(br.readLine());
            if (array2[i] != 0 && array2[i] != 1) {
                System.out.println("Bitte richtig eingeben");
                i--;
            }
        }
        array2[array1.length - 1] = 0;
        System.out.print("Zahl 1: ");
        int[] zahl1 = new int[array1.length];
        for (int i = 0, j = array1.length - 1; i < array1.length; i++, j--) {
            zahl1[i] = array1[j];
            System.out.print(zahl1[i]);
        }
        System.out.println();
        System.out.print("Zahl 2: ");
        int[] zahl2 = new int[array1.length + 1];
        for (int i = 0, j = array1.length - 1; i < array1.length; i++, j--) {
            zahl2[i] = array2[j];
            System.out.print(zahl2[i]);
        }
        System.out.println();
        System.out.print("Ergebnis: ");
        int[] ergebnis = new int[laenge + 1];
        for (int i = 0; i < ergebnis.length; i++) {
            ergebnis[i] = ergebnis[i] + array1[i] + array2[i];
            if (ergebnis[i] > 1) {
                ergebnis[i + 1] = 1;
                ergebnis[i] = 0;
            }
        }
        int[] ausgabe = new int[array1.length + 1];
        for (int i = 0, j = array1.length - 1; i < array1.length; i++, j--) {
            ausgabe[i] = ergebnis[j];
            System.out.print(ausgabe[i]);
        }
        System.out.println();
    }
}
