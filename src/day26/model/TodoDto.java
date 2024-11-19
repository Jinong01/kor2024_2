package day26.model;

public class TodoDto {
    String todo;
    String todoDate;
    boolean complete;

    public TodoDto(){}

    public TodoDto(String todo, String todoDate) {
        this.todo = todo;
        this.todoDate = todoDate;
    }

    public TodoDto(String todo, String todoDate, boolean complete) {
        this.todo = todo;
        this.todoDate = todoDate;
        this.complete = complete;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(String todoDate) {
        this.todoDate = todoDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "todo='" + todo + '\'' +
                ", todoDate='" + todoDate + '\'' +
                ", complete=" + complete +
                '}';
    }
}
