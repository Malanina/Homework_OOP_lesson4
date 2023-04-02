package task4;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static task4.Priority.*;

public class Task implements Comparable<Task>{
    private final int id;
    private Priority priority;
    private String description;
    private String createdDate;
    private String createdTime;
    private String deadlineDate;
    private String deadlineTime;
    private static int counter;

    static {
        counter = 1;
    }

    public Task() {
        this.description = "Task description";
        this.priority = LOW;
        this.createdDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.createdTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        this.deadlineDate = "N/D";
        this.deadlineTime = "N/D";
        this.id = counter++;

    }

    public Task(String description) {
        this.description = description;
        this.priority = LOW;
        this.createdDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.createdTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        this.deadlineDate = "N/D";
        this.deadlineTime = "N/D";
        this.id = counter++;
    }


    public Task(String description, Priority priority) {
        this.description = description;
        this.priority = LOW;
        this.createdDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.createdTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        this.deadlineDate = "N/D";
        this.deadlineTime = "N/D";
        this.id = counter++;
    }

    public Task(String description, Priority priority, String deadlineDate, String deadlineTime) {
        this.description = description;
        this.priority = priority;
        this.createdDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.createdTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        this.deadlineTime = deadlineTime;
        this.deadlineDate = deadlineDate;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getPriority() {
        return switch (priority) {
            case LOW -> "Low priority";
            case MEDIUM -> "Medium priority";
            case HIGH -> "Immediate execution";
            default -> "Not Defined";
        };
    }
    public int getPriorityCode(){
        return switch (priority) {
            case MEDIUM -> 2;
            case HIGH -> 3;
            default -> 1;
        };
    }

    public static Priority setPriorityCode(int number) {
        return switch (number) {
            case 1 -> LOW;
            case 2 -> MEDIUM;
            case 3 -> HIGH;
            default -> LOW;
        };
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    @Override
    public String toString() {
        return "Task №" + getId() +
                ": " + getDescription() +
                ", priority: " + getPriority() +
                ", creation date: " + createdDate +
                ", creation time: " + createdTime +
                ", deadline date: " + deadlineDate +
                ", deadline time: " + deadlineTime;
    }

    @Override
    public int compareTo(Task o) {
        return this.id - o.getId();
    }
}
