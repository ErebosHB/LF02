import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dezimal2Hexadezimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bitte geben Sie ihre Dezimalzahl ein:");
        int dezimal = Integer.parseInt(br.readLine());
        String hexa = "";
        while (dezimal > 0) {
            int zwisch = dezimal % 16;
            if (zwisch > 9) {
                if (zwisch == 10) {
                    hexa = String.valueOf(zwisch);
                    hexa="A";
                }
                if (zwisch == 11) {
                    hexa = String.valueOf(zwisch);
                    hexa="B";
                }
                if (zwisch == 12) {
                    hexa = String.valueOf(zwisch);
                    hexa="C";
                }
                if (zwisch == 13) {
                    hexa = String.valueOf(zwisch);
                    hexa="D";
                }
                if (zwisch == 14) {
                    hexa = String.valueOf(zwisch);
                    hexa="E";
                }
                if (zwisch == 15) {
                    hexa = String.valueOf(zwisch);
                    hexa="F";
                }
                System.out.print(hexa);
            }
            else {
                System.out.print(zwisch);
            }
            dezimal = dezimal / 16;
        }
    }
}
