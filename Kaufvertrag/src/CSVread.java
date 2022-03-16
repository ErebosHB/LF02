import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVread {
    public static void main(String[] args) throws IOException {
        String datei = "H://Programmieren/CSV/Kaufvertrag.csv";
        BufferedReader br = new BufferedReader(new FileReader(datei));
        String zeile;
        while ((zeile = br.readLine()) != null){
            String str = zeile;
            String[] parts = str.split(";");
            System.out.println(Arrays.toString(parts));
        }

    }

}
