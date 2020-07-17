package supernova.easybudget.transactions.infrastructure.entities.enums;

public enum  TransactionType {
    Revenue("Revenue"),
    Expense("Expense");

    private String code;

    private TransactionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    TransactionType() {
    }
}
