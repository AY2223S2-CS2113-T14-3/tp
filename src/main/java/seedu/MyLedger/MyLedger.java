package seedu.myledger;

import seedu.TxtData.TxtFileStatus;
import seedu.expenditure.ExpenditureList;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyLedger {
    private ExpenditureList expenditures;

    private void start() {
        expenditures = new ExpenditureList();
    }

    private void run() {

    }

    public static void main(String[] args) {

        try {
            TxtFileStatus.fileAvailability();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        }
    }

    public static void runMyLedger() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }

}
