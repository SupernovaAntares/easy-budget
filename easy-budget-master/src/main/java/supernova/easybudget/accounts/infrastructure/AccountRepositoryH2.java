package supernova.easybudget.accounts.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import supernova.easybudget.accounts.infrastructure.entities.AccountEntity;

public interface AccountRepositoryH2 extends JpaRepository<AccountEntity, Long> {
}
