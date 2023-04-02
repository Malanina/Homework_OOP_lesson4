package task4;


public interface ExportFormat {
    <T extends Task> String createString(T task);
}  

