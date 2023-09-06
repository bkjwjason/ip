package duke;

import duke.task.Task;

import java.util.Scanner;

/**
 * Ui is a class that handles all UI interactions with the user, through print
 * statements.
 */
public class Ui {
    private Scanner scanner;

    /**
     * Constructs a Ui object with the scanner initialized to scan for
     * user input.
     */
    public Ui() {

        scanner = new Scanner(System.in);
    }

    /**
     * Prints the introduction message when the bot is first launched.
     */
    public String introMessage() {
        return "Hello! I'm BaekBot.\nIf you're unsure of the commands available, type /help. "
                + "\nWhat can I do for you?";
    }

    /**
     * Returns the user input after reading.
     *
     * @return The user's input in type String.
     */
    public String getInput() {
        return scanner.nextLine();
    }

    /**
     * Prints the task that was added to the list.
     *
     * @param task Task that was added to the list.
     * @param count Total count of tasks in the list after addition.
     */
    public String addTaskMessage(Task task, int count) {
        return "Got it. I've added this task:\n" + task
                + "\nNow you have " + count + " tasks in the list.";
    }

    /**
     * Prints the task that was deleted from the list.
     *
     * @param task Task that was deleted from the list.
     * @param count Total count of tasks in the list after deletion.
     */
    public String deleteTaskMessage(Task task, int count) {
        return "Noted. I've removed this task:\n"
                + task + "\nNow you have " + count + " tasks in the list.";
    }

    /**
     * Prints message that notifies user does not have any tasks in the list.
     */
    public String emptyTaskMessage() {
        return "You don't have any tasks right now.";
    }

    /**
     * Prints farewell message when user exits the bot.
     */
    public void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints message containing task when user marks a task as done.
     *
     * @param task Task that was marked done.
     */
    public String markDoneMessage(Task task) {
        return "Nice! I've marked this task as done:\n" + task;
    }

    /**
     * Prints message containing task when user marks a task as not done.
     *
     * @param task Task that was marked not done.
     */
    public String unmarkDoneMessage(Task task) {
        return "OK, I've marked this task as not done yet: \n" + task;
    }

    /**
     * Prints message when there is an error loading data from the savefile.
     */
    public String loadingErrorMessage() {
        return "There was an issue loading your savefile!";
    }

    /**
     * Prints message when user inputs a command that the bot does not understand.
     */
    public String noCommandMessage() {
        return "Sorry, I don't understand what it means :(";
    }

    /**
     * Prints message when user inputs an empty command.
     */
    public String emptyCommandMessage() {
        return "Don't give me an empty command!";
    }

    /**
     * Prints message to inform users about matching tasks
     * that will be displayed after.
     */
    public String displayMatchMessage() {
        return "Here are the matching tasks!";
    }

    /**
     * Prints a string representation of a Task in an ordered list.
     *
     * @param count Integer representing the number of task in ordered list.
     * @param task Task to be printed.
     */
    public String displayTaskMessage(int count, Task task) {
        return count + ". " + task;
    }

    /**
     * Prints message when user has no matching task to find based on input.
     */
    public String noMatchMessage() {
        return "There are no matching tasks!";
    }

    /**
     * Prints message containing all commands that bot recognizes.
     */
    public String helpMessage() {
        return "To view the list of tasks, type list. \nTo add a todo, type todo."
                + "\nTo add a deadline, type deadline with /by.\nTo add a event, type event with /from and /to."
                + "\nTo mark/unmark tasks, type mark/unmark followed by the index."
                + "\nTo delete a task, type delete followed by the index."
                + "\nTo exit, type bye.";
    }

    /**
     * Closes the scanner to stop reading input from user.
     */
    public void closeScanner() {
        scanner.close();
    }
}
