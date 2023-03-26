package seedu.expenditure;

import seedu.commands.SortCommand;
import seedu.exceptions.AlreadyMarkException;
import seedu.exceptions.AlreadyUnmarkException;
import seedu.exceptions.ExceptionChecker;
import seedu.exceptions.NoPaidFieldException;
import seedu.txtdata.TxtFileStatus;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ExpenditureList {
    public static final int LIST_OFFSET = 1;
    private static ArrayList<Expenditure> expenditures;
    private static double budgetSet = 0;

    public ExpenditureList() {
        expenditures = new ArrayList<>();
    }

    public void addExpenditure(Expenditure expenditure) {
        expenditures.add(expenditure);
    }

    public void deleteExpenditure(int index) {
        expenditures.remove(index);
        expenditures.trimToSize();
    }

    public void markExpenditure(int index) throws NoPaidFieldException, AlreadyMarkException {
        Expenditure expenditure = expenditures.get(index);
        if (expenditure instanceof TuitionExpenditure) {
            ExceptionChecker.checkAlreadyMark(expenditure);
            ((TuitionExpenditure) expenditure).setPaid();
        } else if (expenditure instanceof AccommodationExpenditure) {
            ExceptionChecker.checkAlreadyMark(expenditure);
            ((AccommodationExpenditure) expenditure).setPaid();
        } else {
            throw new NoPaidFieldException();
        }
    }

    public void unmarkExpenditure(int index) throws NoPaidFieldException, AlreadyUnmarkException {
        Expenditure expenditure = expenditures.get(index);
        if (expenditure instanceof TuitionExpenditure) {
            ExceptionChecker.checkAlreadyUnmark(expenditure);
            ((TuitionExpenditure) expenditure).resetPaid();
        } else if (expenditure instanceof AccommodationExpenditure) {
            ExceptionChecker.checkAlreadyUnmark(expenditure);
            ((AccommodationExpenditure) expenditure).resetPaid();
        } else {
            throw new NoPaidFieldException();
        }
    }

    public void duplicateExpenditure(int index) {
        Expenditure expenditure = expenditures.get(index);
        addExpenditure(expenditure);
    }

    public void setNewBudget(double budget) {
        budgetSet = budget;
    }

    public double getBudgetSet() {
        return budgetSet;
    }

    public ArrayList<Expenditure> getExpenditures() {
        return expenditures;
    }

    public Expenditure getExpenditure(int index) {
        return expenditures.get(index);
    }

    public int getSize() {
        return expenditures.size();
    }

    @Override
    public String toString() {
        StringBuilder stringOfExpenditures = new StringBuilder();
        for (int i = 0; i < expenditures.size(); i++) {
            final int expenditureNumber = i + LIST_OFFSET;
            stringOfExpenditures.append(String.format("%d. %s\n", expenditureNumber, expenditures.get(i)));
        }
        return stringOfExpenditures.toString().stripTrailing();
    }

    public static String printSpecificDate(LocalDate date) {
        StringBuilder stringOfExpenditures = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < expenditures.size(); i++) {
            Expenditure expenditure = expenditures.get(i);
            if (date.equals(expenditure.getDate())) {
                stringOfExpenditures.append(String.format("%d. %s\n", counter, expenditure));
                counter += 1;
            }
        }
        return stringOfExpenditures.toString().stripTrailing();
    }

    public static String printSpecificType(String expenditureType) {
        StringBuilder stringOfExpenditures = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < expenditures.size(); i++) {
            Expenditure expenditure = expenditures.get(i);
            if (expenditureType.equals(expenditure.getExpenditureType())) {
                stringOfExpenditures.append(String.format("%d. %s\n", counter, expenditure));
                counter += 1;
            }
        }
        return stringOfExpenditures.toString().stripTrailing();
    }

    public static void saveList() {
        try {
            TxtFileStatus.saveExpenditureList(expenditures);
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    public static ExpenditureList sortAmount(String sortType) {
        ArrayList<Expenditure> sortExpenditureAmount = expenditures;
        switch (sortType) {
            case SortCommand.AMOUNT_ASCENDING:
                sortExpenditureAmount.sort(Comparator.comparing(Expenditure::getValue));
                break;
            case SortCommand.AMOUNT_DESCENDING:
                sortExpenditureAmount.sort(Comparator.comparing(Expenditure::getValue).reversed());
                break;
            default:
                break;
        }
        ExpenditureList sortedExpenditures = new ExpenditureList();
        for (Expenditure expenditure : sortExpenditureAmount) {
            sortedExpenditures.addExpenditure(expenditure);
        }
        return sortedExpenditures;
    }

    public static ExpenditureList sortDate(String sortType) {
        ArrayList<Expenditure> sortExpenditureDate = expenditures;
        switch (sortType) {
            case SortCommand.DATE_FROM_EARLIEST:
                sortExpenditureDate.sort(Comparator.comparing(Expenditure::getDate));
                break;
            case SortCommand.DATE_FROM_LATEST:
                sortExpenditureDate.sort(Comparator.comparing(Expenditure::getDate).reversed());
                break;
            default:
                break;
        }
        ExpenditureList sortedExpenditures = new ExpenditureList();
        for (Expenditure expenditure : sortExpenditureDate) {
            sortedExpenditures.addExpenditure(expenditure);
        }
        return sortedExpenditures;
    }
}
