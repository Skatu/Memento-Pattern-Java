import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Editor editor = new Editor();
        Command command = new Command(editor);
        while(true){
            System.out.println("Insert text:");
            String line = br.readLine();
            editor.setText(line);
            System.out.println("Current editor text:\n" + editor.getText());
            System.out.println("Restore? y/n");
            String answer = br.readLine().toLowerCase();
            if(answer.equals("y")){
                if(command.undo()){
                    System.out.println("Restored text:\n"+editor.getText());
                }else{
                    System.out.println("Nothing to undo");
                    command.makeSnapshot();
                }
            }else{
                command.makeSnapshot();
            }
        }
    }
}
