package supernova.easybudget.transactions.infrastructure.entities;

import supernova.easybudget.transactions.infrastructure.entities.enums.TransactionCategory;
import supernova.easybudget.transactions.infrastructure.entities.enums.TransactionType;
import supernova.easybudget.transactions.infrastructure.entities.enums.converter.CategoryConverter;
import supernova.easybudget.transactions.infrastructure.entities.enums.converter.TypeConverter;

import javax.persistence.*;

@Entity(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_Id")
    private Long accountId;

    @Column(name = "transaction_value")
    private Long transactionValue;

    @Column(name = "type")
    @Convert(converter = TypeConverter.class)
    private TransactionType transactionType;

    @Column(name = "category")
    @Convert(converter = CategoryConverter.class)
    private TransactionCategory transactionCategory;

    @Column(name = "from_who")
    private String from;

    @Column(name = "notes")
    private String notes;

    public TransactionEntity() {

    }

    public TransactionEntity(Long id, Long accountId, Long value, TransactionType transactionType, TransactionCategory transactionCategory, String from, String notes) {
        this.id = id;
        this.accountId = accountId;
        this.transactionValue = value;
        this.transactionType = transactionType;
        this.transactionCategory = transactionCategory;
        this.from = from;
        this.notes = notes;
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

    public Long getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Long transactionValue) {
        this.transactionValue = transactionValue;
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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }
}
