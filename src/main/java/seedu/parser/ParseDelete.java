package seedu.parser;

import seedu.commands.Command;
import seedu.commands.DeleteCommand;
import seedu.commands.InvalidCommand;

public class ParseDelete {
    public static final String BLANK = "";
    private final String userInput;

    public ParseDelete(String userInput) {
        this.userInput = userInput;
    }

    public Command deleteItem() {
        try {
            String details = ParseIndividualValue.parseIndividualValue(userInput, BLANK, BLANK);
            int posToDelete = Integer.parseInt(details);
            return new DeleteCommand(posToDelete - 1);
        } catch (NumberFormatException numberFormatException) {
            return new InvalidCommand("Invalid");
        }
    }
}
