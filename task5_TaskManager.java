package cognizify;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TASK {
    private int id;
    private String description;
    private boolean completed;
    private String newTitle;

    public TASK(int id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    // Getters and setters
    public void setDescription(String description) {
        this.description=description;
    }

    @Override
    public String toString() {
        return id + "," + description + "," + completed;
    }

    public static TASK fromString(String line) {
        String[] parts = line.split(",");
        return new TASK(Integer.parseInt(parts[0]), parts[1], Boolean.parseBoolean(parts[2]));
    }


    public void setCompleted(boolean completed) {
        this.completed=completed;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String newTitle) {
        this.newTitle=newTitle;
    }
}

public class task5_TaskManager {
    private static final String FILE_NAME = "tasks.txt";
    private List<TASK> tasks = new ArrayList<>();

    public task5_TaskManager() {
        loadTasksFromFile();
    }

    public void addTask(TASK task) {
        tasks.add(task);
        saveTasksToFile();
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        saveTasksToFile();
    }

    public void updateTask(int id, String description, boolean completed) {
        for (TASK task : tasks) {
            if (task.getId() == id) {
                task.setDescription(description);
                task.setCompleted(completed);
                break;
            }
        }
        saveTasksToFile();
    }

    public List<TASK> getTasks() {
        return tasks;
    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (TASK task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    private void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; // If the file doesn't exist, there are no tasks to load
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(TASK.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading tasks from file: " + e.getMessage());
        }
    }
}