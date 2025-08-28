package main;

public class ActionPerformer {
    private static GetterFromUser getter = new GetterFromUser();
    private static ListWorker listWorker = new ListWorker();

    public void end() {
        System.out.println("thanks!");
    }

    public void printAllTasks() {
        listWorker.printGroupOfTasks(null);
        UserInterface.startProgramMenu();
    }

    public void markAsDone() {
        int id, action;
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
        UserInterface.continueMenu();
    }

    public void changeTaskName() {
        int ID = getter.getID();
        System.out.println("Enter new task name");
        String newName = getter.getString();
        listWorker.changeName(ID, newName);
        System.out.println("Task name has been updated");
    }

    public void changeTaskStatus() {
        int ID = getter.getID();
        System.out.println("Enter status number:" +
                "\n 1. Not started" +
                "\n 2. Started" +
                "\n 3. Done");
        Status status = getter.getStatus();
        listWorker.changeStatus(ID, status);
        System.out.println("Status has been updated");
    }

    public void changeDescription() {
        int ID = getter.getID();
        System.out.println("Enter description:");
        String description = getter.getString();
        listWorker.changeDescription(ID, description);
        System.out.println("Description has been updated");
    }

}
