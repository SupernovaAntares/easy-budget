package supernova.easybudget.accounts.application;

import supernova.easybudget.accounts.domain.model.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> findById(Long accountId);
}
