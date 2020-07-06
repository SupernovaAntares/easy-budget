package supernova.easybudget.accounts.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supernova.easybudget.accounts.domain.model.Account;
import supernova.easybudget.accounts.domain.model.AccountRepository;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Optional<Account> findById(Long accountId) {
        return repository.findById(accountId);
    }
}
