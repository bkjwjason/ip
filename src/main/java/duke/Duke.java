package duke;

import duke.task.TaskList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Region;



/**
 * Duke is a chatbot that helps the user to keep track of Tasks. Users
 * can add, delete, mark tasks as done.
 */
public class Duke extends Application {

    private Storage storage;
    private Ui ui;
    private TaskList tasks;
    private Parser parser;
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    /**
     * Constructs a Duke Object. It will attempt to load saved data
     * and continue to read/write tasks to the saved data.
     * Ui, Storage and the TaskLists are initialized here.
     */
    public Duke() {
        this.ui = new Ui();
        this.storage = new Storage();

        try {
            this.tasks = new TaskList(this.storage.readTasks());
        } catch (DukeException e) {
            this.ui.loadingErrorMessage();
            this.tasks = new TaskList();
        }
        this.parser = new Parser(this.tasks);
    }

    /**
     * Starts the Duke interaction with the User, allowing users to continuously input
     * and modify the TaskList until they type bye.
     */
    public void run() {
        try {
            this.ui.introMessage();
            while (true) {
                String command = ui.getInput();
                if (command.equalsIgnoreCase("bye")) {
                    break;
                }
                this.parser.parse(command);
            }
            this.ui.closeScanner();
            this.storage.writeTasks(this.tasks.getTasks());
            this.ui.byeMessage();
        } catch (DukeException e) {
            System.out.println("OOPS!" + e.toString().split("DukeException:")[1]);
        }
    }


    /**
     * Acts as the main entry Point for the Duke Application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args){
        Duke duke = new Duke();
        duke.run();
    }
}
