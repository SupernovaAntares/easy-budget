package supernova.easybudget.transactions.infrastructure.entities.enums;

public enum TransactionCategory {
    Salary("Salary"),
    Financial_incomming("Financial_incomming"),
    Food("Food"),
    Shopping("Shopping"),
    Transport("Transport"),
    Entertainment("Entertainment"),
    Family("Family"),
    Health_Care("Health_Care"),
    Pets("Pets"),
    Travels("Travels"),
    Others("Others");

    private String code;

    private TransactionCategory(String code) {
        this.code = code;
    }

    TransactionCategory() {

    }

    public String getCode() {
        return code;
    }
}
