public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }


    @Override
    public String save() {
        return "T|" + super.save();
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
