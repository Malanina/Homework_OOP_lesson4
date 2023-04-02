package task4;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println("1 - Добавить дело");
        System.out.println("2 - Вывод всех дел");
        System.out.println("3 - Сортировка дел по важности");
        System.out.println("4 - Удаление дела по номеру");
        System.out.println("5 - Поиск дела по слову");
        System.out.println("6 - Экспорт в XML файл");
        System.out.println("7 - Выход");
    }

    public void startMenu(Planner planner) {
        if (this.scanner != null) {
            String option;
            UserActions actions = new UserActions(scanner, planner);
            do {
                printMenu();
                System.out.print("Введите номер меню:");
                option = this.scanner.nextLine();
                switch (option) {
                    case "1":
                        System.out.println("Добавить новое дело:");
                        actions.addNewTask();
                        break;
                    case "2":
                        System.out.println("Все дела:");
                        actions.showAllTasks();
                        break;
                    case "3":
                        System.out.println("Сортировка дел по важности:");
                        actions.showSortedByPriority();
                        break;
                    case "4":
                        System.out.println("Удаление дела по номеру:");
                        actions.deleteTaskByNumber();
                        break;
                    case "5":
                        System.out.println("Поиск дела по слову:");
                        actions.searchTaskByString();
                        break;
                    case "6":
                        System.out.println("Экспорт в XML файл:");
                        actions.exportTasksToXML();
                        break;
                    case "7":
                        System.out.println("Выход");
                        break;
                    default:
                        System.out.println("Введен некорректный номер меню");
                }
            } while (!option.equals("7"));
        }
    }
}