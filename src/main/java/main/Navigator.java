package main;

public class Navigator {
    private static ActionPerformer actionPerformer = new ActionPerformer();


    public void startmenuNavigator(int action) {
        switch (action) {
            case 1 -> actionPerformer.printAllTasks();
            case 2 -> actionPerformer.markAsDone();
            case 3 -> UserInterface.changeTaskMenu();

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
