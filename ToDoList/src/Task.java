import java.time.LocalDateTime;

public class Task implements Comparable<Task> {


    String TaskTitle;

    LocalDateTime Deadline;

    int workingTime;

    Boolean Done;


    public Task(String TaskTitle, LocalDateTime Deadline, int workingTime, Boolean Done) {

        this.TaskTitle = TaskTitle;
        this.Deadline = Deadline;
        this.workingTime = workingTime;
        this.Done = Done;

    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public String getTaskTitle() {
        return TaskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        TaskTitle = taskTitle;
    }

    public LocalDateTime getDeadline() {
        return Deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        Deadline = deadline;
    }

    public Boolean getDone() {
        return Done;
    }

    public void setDone(Boolean done) {
        Done = done;
    }

    public void addDescription(String TaskDescription) {

        System.out.println(TaskTitle + ":" + TaskDescription);
    }

    @Override
    public int compareTo(Task other) {

    if(Deadline.isEqual(other.Deadline)){

        return Integer.compare(this.workingTime,other.workingTime);

    }else{
        return Deadline.compareTo(other.Deadline);
    }
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskTitle='" + TaskTitle + '\'' +
                ", Deadline=" + Deadline +
                ", workingTime=" + workingTime +
                ", Done=" + Done +
                '}';
    }
}
