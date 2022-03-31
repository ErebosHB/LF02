import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class KonverterDual2Dezimal {
        public static void main (String[]args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Gib eine Dual zahl ein");

            int binaer = 0;

            boolean ok = true;

            while (ok) {

                ok = true;

                binaer = Integer.parseInt(br.readLine());

                LinkedList<Integer> stack = new LinkedList<Integer>();
                int zahl = binaer;
                while (zahl > 0) {
                    stack.push(binaer % 10);
                    zahl = zahl / 10;
                }
                int[] array = new int[stack.size()];
                int i = 0;
                while ((!stack.isEmpty())) {
                    array[i] = stack.pop();
                    i++;
                }
                for (int k : array) {
                    ok = k < 0 || k > 1;
                }
                if (ok) {
                    System.out.println("bitte nochmal");
                }
            }
            int ausgabe = Integer.parseInt(String.valueOf(binaer), 2);
            System.out.println(ausgabe);
        }
    }