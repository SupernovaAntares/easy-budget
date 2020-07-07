package supernova.easybudget.accounts.application;

import supernova.easybudget.accounts.domain.model.Account;
import supernova.easybudget.accounts.infrastructure.entities.AccountEntity;


import java.util.List;
import java.util.Optional;

public interface AccountService {

    Optional<Account> findById(Long accountId);

    List<Account> findAllAccounts();

}
