package task4;

public class ExportToXML implements ExportFormat{

    public static final String XMLFile = null;

    @Override
    public <T extends Task> String createString(T task) {
        return String.format("""
                <xml>
                <Task>
                <id>%d</id>
                <Description>%s</Description>
                <Priority>%s</Priority>
                <Creation date>%s</Creation date>
                <Creation time date>%s</Creation time>
                <Deadline date>%s</Deadline date>
                <Deadline time date>%s</Deadline time>
                </Task></xml>
                """, task.getId(), task.getDescription(), task.getPriority(), task.getCreatedDate(), task.getCreatedTime(), task.getDeadlineDate(),task.getDeadlineTime());
    }
}