public class KeineIdException extends Exception{
    private int id;

    public KeineIdException(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return "Die ID "+getId()+" befindet sich nicht im Tresor.";
    }
}
