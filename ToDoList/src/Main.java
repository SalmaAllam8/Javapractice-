// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {


        // Add tasks to the priority queue

        Task task1 = new Task("Task 1", LocalDateTime.now().plusHours(2),1,false);
        Task task2 = new Task("Task 2", LocalDateTime.now().plusHours(3),1,false);
        Task task3 = new Task("Task 1", LocalDateTime.now().plusHours(2),1,false);

        Todolist listtask = new Todolist();
        listtask.addtask(task1);
        listtask.addtask(task2);
        listtask.addtask(task3);


        String todolistString = listtask.toString();
        System.out.println(todolistString);



        }
    }
