package com.github.confuzzedcat.thursday;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TaskList<Task> theTaskList = new TaskList<>();
        GardenTask gardenTask = new GardenTask("Parken Tur", "en tur i parken", LocalDate.of(2022,10,10), "Parken i parken");

        Task leTask = Task.builder()
                .description("Hoppe 10 gange på vejen")
                .title("Hoppe på vejen")
                .dueDate(LocalDate.of(2023, 9,14))
                .build();

        theTaskList.addTask(gardenTask);
        theTaskList.addTask(leTask);

        System.out.println("printTasks");

        theTaskList.printTasks();

        System.out.println("\nfilterTasks");

        theTaskList.printTasks(theTaskList.filterTasks("park")); // 3.2

        System.out.println("\nsortByDueDate");

        theTaskList.printTasks(theTaskList.sortByDueDate());            // 3.3

        System.out.println("\ngetTasksDueToday");

        theTaskList.printTasks(theTaskList.getTasksDueToday());          // 3.4

        System.out.println("\ngetTasksOverDue");

        theTaskList.printTasks(theTaskList.getTasksOverDue());           // 3.5
    }
}
