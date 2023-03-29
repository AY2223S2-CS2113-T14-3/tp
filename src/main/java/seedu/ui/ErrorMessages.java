package seedu.ui;


public enum ErrorMessages {

    ERROR_MARK_MESSAGE("Sorry! This expenditure is already marked!"),
    ERROR_UNMARK_MESSAGE("Sorry! This expenditure is already unmarked!"),
    ERROR_EMPTY_STRING_MESSAGE("One of your inputs are empty!"),
    ERROR_INVALID_SORT_INPUT_MESSAGE("Invalid sort message!\n " +
                "<sort ascend> to sort amount in ascending order. " +
                "<sort descend> to sort amount in descending order.\n" +
                "<sort earliest> to sort amount from earliest date added. " +
                "<sort latest> to sort amount from latest date added."),
    ERROR_NO_PAID_FIELD_MESSAGE("No paid field for this expenditure!"),
    ERROR_NOT_POSITIVE_VALUE_MESSAGE("Budget set is of a negative value!"),
    ERROR_COMMAND_NOT_RECOGNISED_MESSAGE("Command not recognised. Please try again"),
    ERROR_LACK_OF_PARAMETERS_MESSAGE("Input command does not have required parameters! Please try again"),
    ERROR_DATE_TIME_ERROR_MESSAGE("Date time error! Please try again"),
    ERROR_INVALID_EXPENDITURE_TYPE_MESSAGE("Invalid expenditure type! Please try again"),
    ERROR_NUMBER_FORMAT_MESSAGE("Index must be an integer and within bounds! Please try again"),
    ERROR_WRONG_FORMAT_MESSAGE("Input command cannot be recognised as it is in the wrong format. Please try again"),
    ERROR_BUDGET_NOT_NUMERICAL_MESSAGE("Budget amount is not a numerical value!");
 

    public final String message;

    ErrorMessages(String message) {
        this.message = message;
    }


    public String toString() {
        return message;
    }

}



