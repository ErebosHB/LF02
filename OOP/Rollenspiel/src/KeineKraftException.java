public class KeineKraftException extends Exception{
    private String name;
    private String aktion;

    public KeineKraftException(String name,String aktion){
        this.name = name;
        this.aktion = aktion;
    }

    @Override
    public String getMessage() {
        return name + " ist zu schwach um zu "+aktion;
    }
}
