package supernova.easybudget.accounts.domain.model;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findById(Long accountId);
}
