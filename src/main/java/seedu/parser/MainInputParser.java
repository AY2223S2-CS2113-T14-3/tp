package seedu.parser;

import seedu.commands.Command;
import seedu.commands.EditCommand;
import seedu.commands.HelpCommand;
import seedu.commands.DeleteCommand;
import seedu.commands.ExitCommand;
import seedu.commands.ListExpenditureCommand;
import seedu.commands.ViewDateExpenditureCommand;
import seedu.commands.ViewTypeExpenditureCommand;
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
import seedu.commands.UnmarkCommand;
import seedu.commands.MarkCommand;
import seedu.commands.SortCommand;
import seedu.commands.DuplicateCommand;

import java.time.format.DateTimeParseException;

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
                return new ExitCommand();
            case HelpCommand.COMMAND_WORD:
                return new HelpCommand();
            case DeleteCommand.COMMAND_WORD:
                ParseDelete prepareDelete;
                prepareDelete = new ParseDelete(splitValues[INDEX_USERSTRING]);
                return prepareDelete.deleteItem();
            case MarkCommand.COMMAND_WORD:
                ParseMark prepareMark;
                prepareMark = new ParseMark(splitValues[INDEX_USERSTRING]);
                return prepareMark.markExpenditure();
            case UnmarkCommand.COMMAND_WORD:
                ParseMark prepareUnmark;
                prepareUnmark = new ParseMark(splitValues[INDEX_USERSTRING]);
                return prepareUnmark.unmarkExpenditure();
            case EditCommand.COMMAND_WORD:
                ParseEdit prepareEdit = new ParseEdit(splitValues[INDEX_USERSTRING]);
                return prepareEdit.editItem();
            case SortCommand.COMMAND_WORD:
                ParseSort prepareSort;
                prepareSort = new ParseSort(splitValues[INDEX_USERSTRING]);
                return prepareSort.sortExpenditures();
            case ListExpenditureCommand.COMMAND_WORD:
                return new ListExpenditureCommand();
            case ViewDateExpenditureCommand.COMMAND_WORD:
                return new ViewDateExpenditureCommand(splitValues[INDEX_USERSTRING]);
            case ViewTypeExpenditureCommand.COMMAND_WORD:
                return new ViewTypeExpenditureCommand(splitValues[INDEX_USERSTRING]);
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
                ParseLendBorrow prepareLendBorrowExpenditure;
                prepareLendBorrowExpenditure = new ParseLendBorrow(splitValues[INDEX_USERSTRING]);
                return prepareLendBorrowExpenditure.addItem(command);
            case DuplicateCommand.COMMAND_WORD:
                ParseDuplicate prepareDuplicate = new ParseDuplicate(splitValues[INDEX_USERSTRING]);
                return prepareDuplicate.duplicateItem();
            default:
                // Commands that are not listed above
                return new InvalidCommand("Command not recognised. Please try again");
            }
        } catch (IndexOutOfBoundsException e) {
            return new InvalidCommand("Input command does not have required parameters! Please try again");
        } catch (DateTimeParseException d) {
            return new InvalidCommand("date time error");
        }
    }
}
