package main;

public class UserInterface {
    private static Navigator navigator = new Navigator();
    private static GetterFromUser getter = new GetterFromUser();

    public static final String ACTIONLIST = "Choose action:\n" +
            "1.Check all tasks\n" +
            "2. mark as Done\n" +
            "3. change task\n" +
            "4. delete task\n" +
            "5. add task\n" +
            "6. close";

    public static void startProgramMenu() {
        int action = 0;

        System.out.println(ACTIONLIST);
        do {
            action = getter.getInt();
            if (action < 1 || action > 6) {
                System.out.println("put right action number");
            }
        } while (action < 1 || action > 6);
        navigator.startmenuNavigator(action);
    }

    public static void changeTaskMenu() {
        int fieldToChange;
        boolean isTrueNumber = false;
        do {
            System.out.println("What would you like to change? (1 - task Name/ 2 - task Status/" +
                    " 3  - task Description/ 4 - get back to start menu)");
            fieldToChange = getter.getInt();
            isTrueNumber = navigator.changeNavigator(fieldToChange);
            if (!isTrueNumber) {
                System.out.println("Enter right action and try again!");
            }
        } while (!isTrueNumber);

    }

    public static void continueMenu(){
        System.out.println("Do you wanna continue? (1 - Yes, other one - no)");
        int action = getter.getInt();
        if (action == 1) {
            UserInterface.startProgramMenu();
        } else {
           ActionPerformer ender = new ActionPerformer();
           ender.end();
        }

    }

}




