package businessObjects;

public class Computerspiel {
    private int spielNr;
    private String name;
    private String genre;
    private String releaseDate;
    private int fsk;
    private String rating;
    private double price;
    private String condition;

    public Computerspiel(String name, String genre, String releaseDate, int fsk, double price){
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.fsk = fsk;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getFsk() {
        return fsk;
    }

    public void setFsk(int fsk) {
        this.fsk = fsk;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getSpielNr() {
        return spielNr;
    }

    public void setSpielNr(int spielNr) {
        this.spielNr = spielNr;
    }

    @Override
    public String toString() {
        return "Computerspiel:\n" +
                "Name: " + name + '\n' +
                "Genre: " + genre + '\n' +
                "Release Date: " + releaseDate + '\n' +
                "FSK: " + fsk +"\n"+
                "Rating: " + rating + '\n' +
                "Price: " + price +"\n"+
                "Condition: " + condition + '\n';
    }
}
