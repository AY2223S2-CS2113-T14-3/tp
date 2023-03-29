package seedu.expenditure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowExpenditure extends Expenditure {
    public static final String EXPENDITURE_TYPE = "B";
    private LocalDate deadline;
    private String borrowerName;

    public BorrowExpenditure(String description, String borrowerName, double borrowValue, LocalDate date,
            LocalDate deadline) {
        super(description, borrowValue, date);
        setBorrowerName(borrowerName);
        setDeadline(deadline);
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setBorrowerNameAndDeadline(String lenderName, LocalDate deadline) {
        this.borrowerName = lenderName;
        this.deadline = deadline;
    }

    public String getFullDeadline() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        return getDeadline().format(formatter);
    }

    @Override
    public String toString() {
        return String.format("[Borrow] || Borrowed from: %s || %s || By: %s",
                getBorrowerName(), super.toString(), getFullDeadline());
    }

    @Override
    public String getExpenditureType() {
        return EXPENDITURE_TYPE;
    }

    @Override
    public String saveInfo() {
        return getExpenditureType() +
                "d/" + getDescription() +
                "v/" + getValue() +
                "t/" + getDate() +
                "p/" + "None" +
                "n/" + getBorrowerName() +
                "o/" + getDeadline() + "\n";
    }
}
