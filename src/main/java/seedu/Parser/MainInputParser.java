package seedu.Parser;

import seedu.Expenditure.ExpenditureList;
import seedu.MyLedger.MyLedger;
import seedu.commands.*;

public class MainInputParser {
    public static Command parseInputs(String line, ExpenditureList expenditures) {
        String [] splitValues = line.split(" ", 2);
        String command = splitValues[0];

        switch (command) {
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();
        case DeleteCommand.COMMAND_WORD:
            return MyLedger.deleteItem(line);
        case EditCommand.COMMAND_WORD:
            return MyLedger.editItem(line);
        case ViewExpenditureCommand.COMMAND_WORD:
            return new ViewExpenditureCommand();
        case AcademicExpenditureCommand.COMMAND_WORD:
        case AccommodationExpenditureCommand.COMMAND_WORD:
        case EntertainmentExpenditureCommand.COMMAND_WORD:
        case FoodExpenditureCommand.COMMAND_WORD:
        case OtherExpenditureCommand.COMMAND_WORD:
        case TransportExpenditureCommand.COMMAND_WORD:
        case TuitionExpenditureCommand.COMMAND_WORD:
            return MyLedger.addItem(line, command);
        case LendExpenditureCommand.COMMAND_WORD:
        case BorrowExpenditureCommand.COMMAND_WORD:
        default:
            // Commands that are not listed above
            return new InvalidCommand("Invalid");
        }
    }
}
