import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class CSVread {
    public static void main(String[] args) throws IOException {
        String datei = "H://Programmieren/CSV/Kaufvertrag.csv";
        BufferedReader br = new BufferedReader(new FileReader(datei));
        String zeile;
        Vertragspartner kaeufer = null;
        Vertragspartner verkaeufer = null;

        while ((zeile = br.readLine()) != null){
            String str = zeile;
            String[] parts = str.split(";");
            String[] name = parts[1].split(" ");
            String[] erstes = parts[3].split(" ");
            String adresse ="";
            String ort ="";
            for (int i = 0; i < erstes.length-1;i++){
                adresse += erstes[i] +" ";
                adresse = adresse.trim();
            }
            String[] zweites = parts[4].split(" ");
            for (int j = 1; j < zweites.length;j++){
                ort = zweites[j]+" ";
                ort = ort.trim();
            }



            System.out.println(Arrays.toString(parts));
            if (Objects.equals(parts[0], "Verkaeufer")){
                verkaeufer = new Vertragspartner(name[0],name[1]);
                verkaeufer.setAusweisNr(parts[2]);
                verkaeufer.setAdresse(new Adresse(adresse.toString(),erstes[erstes.length-1],zweites[0],zweites[zweites.length-1]));
            }
            if (Objects.equals(parts[0], "Kaeufer")){
                kaeufer = new Vertragspartner(name[0],name[1]);
                kaeufer.setAusweisNr(parts[2]);
                kaeufer.setAdresse(new Adresse(adresse.toString(),erstes[erstes.length-1],zweites[0],zweites[zweites.length-1]));
            }
        }
        System.out.println(kaeufer);
        System.out.println(verkaeufer);

    }

}
