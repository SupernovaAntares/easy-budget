package supernova.easybudget.accounts.infrastructure.entities;

import javax.persistence.*;

@Entity(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private Long accountValue;
    private String currency;
    private String notes;

    public AccountEntity(Long id, String name, Long accountValue, String currency, String notes) {
        this.id = id;
        this.name = name;
        this.accountValue = accountValue;
        this.currency = currency;
        this.notes = notes;
    }

    public AccountEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(Long accountValue) {
        this.accountValue = accountValue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
