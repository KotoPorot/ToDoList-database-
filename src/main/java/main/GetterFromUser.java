package main;

import java.util.Scanner;

public class GetterFromUser {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        if (scanner.hasNextInt()) {
            int action = scanner.nextInt();
            scanner.nextLine();
            return action;
        } else {
            System.out.println("There is must be a positive number");
            scanner.nextLine();
            return getInt();
        }
    }

    public static String getString() {
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            return input;
        } else {
            System.out.println("There is must be a line");
            return getString();
        }
    }

    public static int getID(String str) {
        int ID = 0;
        ListWorker listWorker = new ListWorker();
        do {
            System.out.println(str+"\n if you want to close app enter 0");
            ID = getInt();
            if (ID==0){
                ActionPerformer ender = new ActionPerformer();
                ender.end();
            } else if (!listWorker.idCheck(ID)) {
                System.out.println("Wrong ID, try again!");
                continue;
            }
        } while (!listWorker.idCheck(ID));
        return ID;
    }

    public static Status getStatus() {
        int statusNumber = getInt();

        switch (statusNumber) {
            case 1 -> {
                return Status.NOTSTARTED;
            }
            case 2 -> {
                return Status.STARTED;
            }
            case 3 -> {
                return Status.DONE;
            }
            default -> {
                System.out.println("Wrong status number, try again!");
                getStatus();
                return null;
            }
        }
    }

    public static void closeGetter(){
        try {
            scanner.close();
            System.out.println("Scanner has been closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


