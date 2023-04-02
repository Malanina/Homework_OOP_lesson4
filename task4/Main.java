package task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Planner planner = new Planner();
        planner.add(new Task("Сдать домашнюю работу", Priority.HIGH,"03.04.2023", "21:00"));
        planner.add(new Task("Сдать отчет на работе", Priority.MEDIUM, "05.04.2023", "16:00"));

        new Menu(new Scanner(System.in)).startMenu(planner);
    }
}
