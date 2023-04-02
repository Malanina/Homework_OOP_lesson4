package task4;

import java.util.Scanner;

public class UserActions implements DoUser {
    private final Scanner scanner;
    private final Planner planner;
    protected static String XMLFile = "/Homework_OOP_lesson4/task4/Planner.xml";

    public UserActions(Scanner scanner, Planner planner) { 
        this.scanner = scanner;
        this.planner = planner;
    }

    @Override
    public void addNewTask() {
        System.out.println("Добавьте дело.");
        String descr = scanner.nextLine();

        System.out.println("\nОпределите приоритет дела: 1 - низкий, 2 - средний, 3 - немедленное выполнение.");
        String prior = scanner.nextLine();
        int priority = 0;
        if (prior.equals("1") | prior.equals("2") | prior.equals("3"))
            priority = Integer.parseInt(prior);
        else
            System.out.println("В таком случае, делу присвоен низкий приоритет.");

    

        System.out.println("Добавьте дату дедлайна в формате дд.мм.гггг");
        String deadlineDate = scanner.nextLine();

        System.out.println("Длбавьте время дедлайна в формате чч:мм");
        String deadlineTime = scanner.nextLine();

        planner.add(new Task(descr, Task.setPriorityCode(priority), deadlineDate, deadlineTime));
    }

    @Override
    public void showAllTasks() {
        if (planner.getSize() > 0)
            planner.showAll();
        else
            System.out.println("Нет запланированных дел.");
    }

    @Override
    public void showSortedByPriority(){
        if (planner.getSize() > 0)
            planner.showSortedByPriority();
        else
            System.out.println("Нет срочных дел.");
    }

    @Override
    public void deleteTaskByNumber(){
        if (planner.getSize() > 0) {
            System.out.println("Укажите номер дела для удаления.");
            int number = Integer.parseInt(scanner.nextLine());
            planner.delete(number);
        } else {
            System.out.println("Не найдено.");
        }
    }

    @Override
    public void searchTaskByString(){
        if (planner.getSize() > 0) {
            System.out.println("Введите слово для поиска дела в планировщике дел.");
            String keyword = scanner.nextLine();
            planner.totalSearch(keyword);
        } else {
            System.out.println("Не найдено.");
        }
    }


    @Override
    public void exportTasksToXML(){
        IteratorOfPlanner iteratorOfPlanner = new IteratorOfPlanner(planner);
        while (iteratorOfPlanner.hasNext()) {
            ExportModel<Task> saved = new ExportModel<>(iteratorOfPlanner.next());
            saved.setFormat(new ExportToXML());
            saved.setPath(ExportToXML.XMLFile);
            saved.save();
        }
        System.out.println("Сохранено в файле в формате xml.");
    }
}
