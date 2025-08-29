package main;

public class ActionPerformer {
    private static GetterFromUser getter = new GetterFromUser();
    private static ListWorker listWorker = new ListWorker();

    public void end() {
        Conector.closeConnection();
        GetterFromUser.closeGetter();
        System.out.println("thanks!");
        System.exit(0);
    }

    public void printAllTasks() {
        listWorker.printGroupOfTasks(null);
    }

    public void markAsDone() {
        int id;
        boolean isTrueId = false;

        do {
            System.out.println("Enter task ID: \n if you want to come back  - enter 0");
            id = getter.getInt();
            if (id < 0) {
                System.out.println("Enter positive index");
                continue;
            } else if (id == 0) {
                UserInterface.startProgramMenu();
                break;
            } else {
                isTrueId = listWorker.idCheck(id);
            }
        } while (!isTrueId);

        listWorker.changeStatus(id, Status.DONE);
        System.out.println("Status has been updated");
    }

    public void changeTaskName() {
        int ID = getter.getID("Enter task ID to change name");
        System.out.println("Enter new task name");
        String newName = getter.getString();
        listWorker.changeName(ID, newName);
        System.out.println("Task name has been updated");
    }

    public void changeTaskStatus() {
        int ID = getter.getID("Enter task ID to change status");
        System.out.println("Enter status number:" +
                "\n 1. Not started" +
                "\n 2. Started" +
                "\n 3. Done");
        Status status = getter.getStatus();
        listWorker.changeStatus(ID, status);
        System.out.println("Status has been updated");
    }

    public void changeDescription() {
        int ID = getter.getID("Enter task ID to change description");
        System.out.println("Enter description:");
        String description = getter.getString();
        listWorker.changeDescription(ID, description);
        System.out.println("Description has been updated");
    }

    public void deleteTask(){
        int ID = getter.getID("Enter task ID to delete task");
        String taskName = listWorker.getTaskName(ID);
        listWorker.deleteTask(ID);
        System.out.println("task: "+taskName +" has been deleted");
    }

    public void addTask(){
        System.out.println("Enter task name: ");
        String taskName = GetterFromUser.getString();
        System.out.println("Enter task description");
        String taskDescription= GetterFromUser.getString();
        listWorker.addTask(taskName, taskDescription);
        System.out.println("Done!");
    }

}
