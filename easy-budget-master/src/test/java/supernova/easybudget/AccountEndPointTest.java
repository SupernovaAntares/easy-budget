package supernova.easybudget;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import supernova.easybudget.accounts.domain.model.Account;
import supernova.easybudget.accounts.infrastructure.AccountRepositoryDatabase;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = EasyBudgetApplication.class)
public class AccountEndPointTest {


    @Autowired
    private AccountRepositoryDatabase repositoryDatabase;

    @Test
    public void insertShouldPersistData(){
        Account account = new Account((long) 3, "Jow", (long) 200, "BRL-R$", "Conta Jow");
        this.repositoryDatabase.insert(account);
        assertThat(account.getId()).isNotNull();
        assertThat(account.getName()).isEqualTo("Jow");
        assertThat(account.getValue()).isEqualTo(200);
        assertThat(account.getCurrency()).isEqualTo("BRL-R$");
        assertThat(account.getNotes()).isEqualTo("Conta Jow");
    }
}
