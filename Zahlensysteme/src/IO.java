import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readstring() throws IOException {
        /**
         * Liest einen Text von der Konsole ein
         * @return Der eingelesene Text
         * @throws IOException
         */
        String eingabe1 = br.readLine();
        return eingabe1;
    }

    public static int readInteger() throws IOException {
        while (true) {
            try {
                String eingabe1 = IO.readstring();
                int eingabeZahl = Integer.parseInt(eingabe1);
                return eingabeZahl;
            } catch (NumberFormatException e) {
                System.out.println("Keine Ganzzahl! Bitte erneut versuchen:");
            }
        }
    }

    public static double readDouble() throws IOException {
        while (true) {
            try {
                String eingabe = IO.readstring();
                double eingabeZahl = Double.parseDouble(eingabe.trim().replace(",", "."));
                return eingabeZahl;
            } catch (NumberFormatException e) {
                System.out.println("Keine Zahl! Bitte erneut versuchen: ");
            }
        }
    }

    public static boolean readBoolean() throws IOException {
        while (true) {
            String eingabe = IO.readstring();
            if (eingabe != null) {
                if (eingabe.equalsIgnoreCase("Ja") || eingabe.equalsIgnoreCase("j") || eingabe.equalsIgnoreCase("yes")) {
                    return true;
                } else if (eingabe.equalsIgnoreCase("Nein") || eingabe.equalsIgnoreCase("n") || eingabe.equalsIgnoreCase("no")) {
                    return false;
                }
            }
            System.out.println("Ungültige Eingabe! Bitte erneut versuchen:");
        }

    }

    public static int[] readIntArray() throws IOException {
        System.out.println("Wie lang soll das Array sein ?");
        int anzahl = IO.readInteger();
        int[] array = readIntArray(anzahl);
        return array;
    }

    public static int[] readIntArray(int n) throws IOException {
        int[] array = new int[n];
        array = readIntArray(array);
        return array;
    }

    public static int[] readIntArray(int[] array) throws IOException {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Wert eingeben für [" + (i + 1) + "] : ");
            array[i] = readInteger();
        }
        return array;
    }


    public static double[] readDoubleArray() throws IOException {
        System.out.println("Wie lang soll das Array sein ?");
        int anzahl = IO.readInteger();
        double[] array = readDoubleArray(anzahl);
        return array;
    }

    public static double[] readDoubleArray(int n) throws IOException {
        double[] array = new double[n];
        array = readDoubleArray(array);
        return array;
    }

    public static double[] readDoubleArray(double[] array) throws IOException {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Wert eingeben für [" + (i + 1) + "] : ");
            array[i] = readDouble();
        }
        return array;

    }

    public static String[] readStringArray() throws IOException {
        System.out.println("Wie lang soll das Array sein ?");
        int anzahl = IO.readInteger();
        String[] array = readStringArray(anzahl);
        return array;
    }

    public static String[] readStringArray(int n) throws IOException {
        String[] array = new String[n];
        array = readStringArray(array);
        return array;
    }

    public static String[] readStringArray(String[] array) throws IOException {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Wert eingeben für [" + (i + 1) + "] : ");
            array[i] = readstring();
        }
        return array;

    }

    public static int[][] readIntArray2D() throws IOException {
        System.out.println("Wie lang soll dein Array sein?");
        int lang = readInteger();
        System.out.println("Wie breit soll dein Array sein?");
        int breit = readInteger();
        int[][] array2d = readIntArray2D(lang,breit);
        return array2d;
    }

    public static int[][] readIntArray2D(int n, int m) throws IOException{
        int[][] array2d = new int[n][m];
        for (int i = 0; i < array2d.length; i++){
            for (int j = 0 ; j < array2d[i].length; j++){
                array2d[i][j] = readInteger();
            }
        }

        return array2d;
    }

    public static int[][] readIntArray2D(int[][] array2d) throws IOException{
        for (int i = 0; i < array2d.length; i++){
            for (int j = 0; j < array2d[i].length; j++){
                System.out.println("Wert eingeben für ["+i+"]["+i+"] : ");
                array2d[i][j] = IO.readInteger();

            }
        }
        return array2d;
    }
    public static int[][] systemOutPrintArray2D(int[][] array2d) throws IOException{

        for (int i = 0 ; i< array2d.length;i++){
            for (int j = 0; j<array2d[i].length; j++){
                System.out.print(array2d[i][j] +"\t");
            }
            System.out.println();
        }
        return array2d;
    }



    public static double[][] readDouble2D() throws IOException {
        System.out.println("Wie lang soll dein Array sein?");
        int lang = readInteger();
        System.out.println("Wie breit soll dein Array sein?");
        int breit = readInteger();
        double[][] array2d = new double[lang][breit];

        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                array2d[i][j] = i - j;
                System.out.println(array2d[i][j]);
            }
        }
        return array2d;
    }
    public static String[][] readStringArray2D() throws IOException{

        System.out.println("Wie viele Zeilen?");

        int zeilen = readInteger();

        System.out.println("Wie viele Spalten?");

        int spalten = readInteger();

        String[][] array = readStringArray2D(zeilen, spalten);

        return array;

    }





    public static String[][] readStringArray2D(int anzahlZeilen, int anzalSpalten) throws IOException {

        String[][] array = new String[anzahlZeilen][anzalSpalten];

        return array;

    }



    public static String[][] readStringArray2D(String[][] array) throws IOException{

        for (int i = 0 ; i< array[i].length;i++) {

            for (int j = 0; j < array[i].length; j++) {

                System.out.println("Gib den wert ein der an der stelle [" + i + "][" + i + "] stehen soll");

                array[i][j] = readstring();

            }

        }

        return array;

    }

    public static String[][] systemOutPrintArray2D(String[][] array) throws IOException{

        for (int i = 0; i<array.length;i++){

            for (int j = 0; j < array[i].length; j++) {

                System.out.print(array[i][j] + "\t");

            }

            System.out.println();

        }

        return array;

    }





}