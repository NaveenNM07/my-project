import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + description;
    }
}

public class ToDoList {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    markTaskAsComplete();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully.");
    }

    private static void deleteTask() {
        displayTasks();
        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt();
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void markTaskAsComplete() {
        displayTasks();
        System.out.print("Enter task number to mark as complete: ");
        int index = scanner.nextInt();
        if (index > 0 && index <= tasks.size()) {
            tasks.get(index - 1).markAsCompleted();
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}