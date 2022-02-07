package Schritt6;

public class SpielAbbruchException extends Exception{
    private int Spielminute;

    public SpielAbbruchException(int Spielminute){
        this.Spielminute = Spielminute;
    }

    public int getSpielminute() {
        return Spielminute;
    }

    @Override
    public String getMessage() {
        return "\nSpielabbruch nach "+getSpielminute()+"min";
    }
}
