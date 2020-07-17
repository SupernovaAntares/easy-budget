package supernova.easybudget.transactions.domain.model;

public class Transaction {

    private Long id;
    private Long accountId;
    private Long value;
    private String type;
    private String category;
    private String from;
    private String notes;

    public Transaction() {
    }

    public Transaction(Long id, Long accountId, Long value, String type, String category, String from, String notes) {
        this.id = id;
        this.accountId = accountId;
        this.value = value;
        this.type = type;
        this.category = category;
        this.from = from;
        this.notes = notes;
    }

    public Transaction(Long id) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
