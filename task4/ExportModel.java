package task4;

public class ExportModel <T  extends Task> {
    ExportFormat format;
    String text;
    String path;
    T task;
    public ExportModel(T task) {
        this.task = task;
    }

    public void setFormat(ExportFormat format) {
        this.format = format;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void save() {
        text = format.createString(task);
        SaveFile.saveTextToFile(text, this.path);

    }
}