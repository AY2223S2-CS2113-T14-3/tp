package seedu.ui;

public class Ui {
    public static final String LOGO = " _  _  _  _  __    ____  ____   ___  ____  ____\n"
            + "( \\/ )( \\/ )(  )  (  __)(    \\ / __)(  __)(  _ \\\n" +
            "/ \\/ \\ )  / / (_/\\ ) _)  ) D (( (_ \\ ) _)  )   / \n" +
            "\\_)(_/(__/  \\____/(____)(____/ \\___/(____)(__\\_)\n";
    public static final String HORIZONTAL_LINE = "----------------------------------------------" + 
        "--------------------------------------------------------------------";
    public static final String WELCOME_MESSAGE = "Hello there, Welcome to\n";
    public static final String INSTRUCTIONS = "\nHere are the list possible commands: "
            + "add, delete, edit, list, borrow, lend, exit\n";
    public static final String HELP_MESSAGE = "If this is your first time here, "
            + "Type <help> to learn more about the commands\n";
    public static final String HELP_PAGE = "Here are the list of commands and their respective functions. "
            + "Please take note of the FORMAT that is stated below\n"
            + HORIZONTAL_LINE +
            "\n1. Add an expenditure to the record\n" +
            "Format: EXPENDITURE_TYPE d/DATE a/AMOUNT s/DESCRIPTION\n" + 
            "There are 7 EXPENDITURE_TYPE: 'Academic', 'Accommodation', 'Entertainment', " +
            "'Food', 'Transport', 'Tuition', 'Other'\n" +
            "Example: academic d/2023-02-02 a/25.10 s/NUS\n" +
            HORIZONTAL_LINE +
            "\n2. Add a lend/borrow record\n" +
            "Format: TYPE d/DATE n/NAME a/AMOUNT b/DEADLINE s/DESCRIPTION\n" +
            "TYPE should be either 'lend' or 'borrow'\n"+
            "Example: lend d/2023-02-02 n/Akshay Narayan a/25.10 b/2023-04-02 s/CS2113\n" +
             HORIZONTAL_LINE +
            "\n3. Delete a specified expenditure from the record\n" +
            "Format: delete INDEX\n" +
            "Example: delete 1 \n" +
            HORIZONTAL_LINE +
            "\n4. Edit an expenditure\n"
            + "Format: edit INDEX d/DATE a/AMOUNT s/DESCRIPTION\n" +
            "Cannot change an expenditure type\n" +
            "Example: edit 2 d/2023-02-15 a/20.00 s/Eat Food\n" +
            HORIZONTAL_LINE +
            "\n4. Edit a Lend/Borrow record\n"
            + "Format: edit INDEX d/DATE n/NAME a/AMOUNT b/DEADLINE s/DESCRIPTION\n" +
            "Cannot change a lend record to a borrow record\n" +
            "Example: edit 17 d/2023-02-02 n/Akshay Narayan a/25.10 b/2023-04-02 s/CS2040\n" +
            HORIZONTAL_LINE +
            "\n4. List all expenditures in the record\n"
            + "Example: list\n" +
            HORIZONTAL_LINE +
            "\n5. Sort the expenditure list\n"
            + "Format: sort TYPE\n" +
            "Types:\n" +
            "ascend: sort by ascending amount || descend: sort by descending amount\n" +
            "latest: sort from latest date || earliest: sort from earliest date\n" +
            "Example: sort latest\n" +
            HORIZONTAL_LINE +
            "\n6. List all expenditures and their total amount in the record BY DATE\n"
            + "Format: viewdate DATE\n"
            + "Example: viewdate 2023-03-29\n" +
            HORIZONTAL_LINE +
            "\n7. List all expenditures and their total amount in the record BY CATEGORY\n"
            + "Format: viewtype CATEGORY\n"
            + "There are 7 EXPENDITURE_TYPE: 'Academic', 'Accommodation', 'Entertainment'," +
            "'Food', 'Transport', 'Tuition', 'Other'.\n" +
            "  This includes 'Borrow' and 'Lend'.\n"
            + "Example: viewtype food\n" +
            HORIZONTAL_LINE +
            "\n8. Set a fixed budget for money management\n"
            + "Format: set AMOUNT\n"
            + "Example: set 150\n" +
            HORIZONTAL_LINE +
            "\n9. Check expenditure with respect to set allocated budget\n"
            + "Format: check\n"
            + "This command helps you manage your budget to check if you are overspending" +
            " and how much leeway you have!\n"
            + "Example: viewdate 2023-03-29\n" +
            HORIZONTAL_LINE;

        

    public static void greetUser() {
        System.out.println(WELCOME_MESSAGE + LOGO + INSTRUCTIONS + HELP_MESSAGE);
    }

}
