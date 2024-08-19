import java.util.Stack;

public class Command {
    private final Editor editor;
    //Implemented as a stack, but in actually, it should be implemented as a Tree to allow
    // for different branches of the same snapshot
    private final Stack<Snapshot> backup;

    public Command(Editor editor) {
        this.editor = editor;
        this.backup = new Stack<>();
    }

    public void makeSnapshot(){
        Snapshot snapshot = editor.createSnapshot();
        backup.push(snapshot);
    }

    public boolean undo(){
        if(backup.isEmpty()) return false;
        Snapshot snapshot = backup.pop();
        snapshot.restore();
        return true;
    }
}
