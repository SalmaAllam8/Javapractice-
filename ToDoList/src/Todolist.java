
import java.util.PriorityQueue;

public class Todolist  {


PriorityQueue<Task> listoftasks = new PriorityQueue<Task>();

    public void addtask(Task task){

        listoftasks.add(task);
    }
public void onetaskisdone(){

    assert listoftasks.peek() != null;
    listoftasks.peek().Done =true;

}

public void removetask(Task task){

        listoftasks.remove(task);

}


   @Override
    public String toString() {
       return"Todolist{" +
                "listoftasks=" + listoftasks.stream().map(Task::toString).toList() +
                '}';
   }





}
