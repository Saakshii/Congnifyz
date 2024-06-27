package cognizify;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}

public class task3_TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nTask Manager:");
            System.out.println("1. Create Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    readTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting Task Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void createTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(title, description));
        System.out.println("Task created successfully.");
    }

    private static void readTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void updateTask() {
        System.out.print("Enter task number to update: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Task task = tasks.get(taskNumber - 1);

        System.out.print("Enter new title (leave blank to keep current): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) {
            task.setTitle(newTitle);
        }

        System.out.print("Enter new description (leave blank to keep current): ");
        String newDescription = scanner.nextLine();
        if (!newDescription.isEmpty()) {
            task.setDescription(newDescription);
        }

        System.out.print("Is the task completed? (yes/no): ");
        String completedStr = scanner.nextLine();
        if (completedStr.equalsIgnoreCase("yes")) {
            task.setCompleted(true);
        } else if (completedStr.equalsIgnoreCase("no")) {
            task.setCompleted(false);
        }

        System.out.println("Task updated successfully.");
    }

    private static void deleteTask() {
        System.out.print("Enter task number to delete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(taskNumber - 1);
        System.out.println("Task deleted successfully.");
    }
}