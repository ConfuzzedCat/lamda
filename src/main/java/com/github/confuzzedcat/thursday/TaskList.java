package com.github.confuzzedcat.thursday;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class TaskList<T extends Task> implements Iterable<T> {
    private List<T> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(T task) {
        tasks.add(task);
    }

    public List<T> getTasks() {
        return tasks;
    }

    //3.2 Filter tasks based on a keyword in the title or description.
    public List<T> filterTasks(String keyword){
         return tasks.stream()
                .filter(task -> (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)))
                .toList();
    }

    // 3.3 Sort tasks by due date.
    public List<T> sortByDueDate(){
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .toList();
    }

    // 3.4 Get tasks that are due today.
    public List<T> getTasksDueToday(){
        return tasks.stream()
                .filter(task -> {
                    Period period = Period.between(LocalDate.now(), task.getDueDate());
                    return period.isZero();
                })
                .toList();
    }

    // 3.5 Get tasks that are overdue.
    public List<T> getTasksOverDue(){
        return tasks.stream()
                .filter(task -> {
                    Period period = Period.between(LocalDate.now(), task.getDueDate());
                    return period.isNegative();
                })
                .toList();
    }

    // 3.6 Print the list of tasks.
    public void printTasks(){
        tasks.forEach(System.out::println);
    }

    // 3.7 Print the list of tasks.
    public void printTasks(List<T> taskList){
        taskList.forEach(System.out::println);
    }

    @Override
    public Iterator iterator() {
        return tasks.iterator();
    }

    public static void _main(String[] args) {
        List<Task> task32 = new TaskList<Task>().filterTasks("indkøb");  // 3.2
        List<Task> task33 = new TaskList<Task>().sortByDueDate();               // 3.3
        List<Task> task34 = new TaskList<Task>().getTasksDueToday();             // 3.4
        List<Task> task35 = new TaskList<Task>().getTasksOverDue();              // 3.5
        new TaskList<Task>().printTasks();                                      // 3.6
        new TaskList<Task>().printTasks(task35);                                // 3.7

    }
}