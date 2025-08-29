package main;

public class Navigator {
    private static ActionPerformer actionPerformer = new ActionPerformer();


    public void startmenuNavigator(int action) {
        switch (action) {
            case 1 -> {
                actionPerformer.printAllTasks();
                UserInterface.continueMenu();
            }
            case 2 -> {
                actionPerformer.markAsDone();
                UserInterface.continueMenu();
            }
            case 3 -> {
                UserInterface.changeTaskMenu();
                UserInterface.continueMenu();
            }
            case 4 -> {
                actionPerformer.deleteTask();
                UserInterface.continueMenu();
            }
            case 5 -> {
                actionPerformer.addTask();
                UserInterface.continueMenu();
            }
            case 6 -> actionPerformer.end();

        }

    }

    public boolean changeNavigator(int action) {
        switch (action) {
            case 1 -> {
                actionPerformer.changeTaskName();
                return true;
            }
            case 2 -> {
                actionPerformer.changeTaskStatus();
                return true;
            }
            case 3 -> {
                actionPerformer.changeDescription();
                return true;
            }
            case 4 -> {
                UserInterface.startProgramMenu();
                return true;
            }

            default -> {
                return false;
            }
        }


    }


}
