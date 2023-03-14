package seedu.parser;

import seedu.expenditure.ExpenditureList;
import seedu.commands.Command;
import seedu.commands.EditCommand;
import seedu.commands.HelpCommand;
import seedu.commands.DeleteCommand;
import seedu.commands.ExitCommand;
import seedu.commands.ViewExpenditureCommand;
import seedu.commands.AcademicExpenditureCommand;
import seedu.commands.AccommodationExpenditureCommand;
import seedu.commands.EntertainmentExpenditureCommand;
import seedu.commands.FoodExpenditureCommand;
import seedu.commands.OtherExpenditureCommand;
import seedu.commands.TransportExpenditureCommand;
import seedu.commands.TuitionExpenditureCommand;
import seedu.commands.LendExpenditureCommand;
import seedu.commands.BorrowExpenditureCommand;
import seedu.commands.InvalidCommand;

public class MainInputParser {
    public static final int LIMIT = 2;
    public static final int INDEX_COMMAND = 0;
    public static final int INDEX_USERSTRING = 1;

    public static Command parseInputs(String userInput) {
        String[] splitValues = userInput.split(" ", LIMIT);
        String command = splitValues[INDEX_COMMAND];
        try {
            switch (command) {
            case ExitCommand.COMMAND_WORD:
            case HelpCommand.COMMAND_WORD:
                return new HelpCommand();
            case DeleteCommand.COMMAND_WORD:
                ParseDelete prepareDelete;
                prepareDelete = new ParseDelete(splitValues[INDEX_USERSTRING]);
                return prepareDelete.deleteItem();
            case EditCommand.COMMAND_WORD:
                ParseEdit prepareEdit = new ParseEdit(splitValues[INDEX_USERSTRING]);
                return prepareEdit.editItem();
            case ViewExpenditureCommand.COMMAND_WORD:
                return new ViewExpenditureCommand();
            case AcademicExpenditureCommand.COMMAND_WORD:
            case AccommodationExpenditureCommand.COMMAND_WORD:
            case EntertainmentExpenditureCommand.COMMAND_WORD:
            case FoodExpenditureCommand.COMMAND_WORD:
            case OtherExpenditureCommand.COMMAND_WORD:
            case TransportExpenditureCommand.COMMAND_WORD:
            case TuitionExpenditureCommand.COMMAND_WORD:
                ParseAdd prepareAddExpenditure;
                prepareAddExpenditure = new ParseAdd(splitValues[INDEX_USERSTRING]);
                return prepareAddExpenditure.addItem(command);
            case LendExpenditureCommand.COMMAND_WORD:
            case BorrowExpenditureCommand.COMMAND_WORD:
                ExpenditureList.saveList();
                ParseLendBorrow prepareLendBorrowExpenditure;

                prepareLendBorrowExpenditure = new ParseLendBorrow(splitValues[INDEX_USERSTRING]);

                return prepareLendBorrowExpenditure.addItem(command);
            default:
            // Commands that are not listed above
            return new InvalidCommand("Command not recognised. Please try again");
            }
        } catch (IndexOutOfBoundsException e) {
            return new InvalidCommand("Input command does not have required parameters! Please try again");
        }
    }
}
