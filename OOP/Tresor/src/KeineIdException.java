public class KeineIdException extends Exception{
    private final int id;

    public KeineIdException(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return "\nDie ID "+getId()+" befindet sich nicht im Tresor.";
    }
}
