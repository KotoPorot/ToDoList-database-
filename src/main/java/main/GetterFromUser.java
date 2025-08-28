package main;

import java.util.Scanner;

public class GetterFromUser {
    private final Scanner scanner = new Scanner(System.in);

    public int getInt() {
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

    public String getString() {
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            return input;
        } else {
            System.out.println("There is must be a line");
            return getString();
        }
    }

    public int getID() {
        int ID = 0;
        ListWorker listWorker = new ListWorker();
        do {
            System.out.println("Enter task ID to change: ");
            ID = getInt();
            if (!listWorker.idCheck(ID)) {
                System.out.println("Wrong ID, try again!");
                continue;
            }
        } while (!listWorker.idCheck(ID));
        return ID;
    }

    public Status getStatus() {
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


}


