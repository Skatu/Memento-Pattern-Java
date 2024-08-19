public class Editor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    protected Snapshot createSnapshot(){
        return new Snapshot(this, text);
    }
    //used for UI only
    public String getText(){
        return text;
    }
}
