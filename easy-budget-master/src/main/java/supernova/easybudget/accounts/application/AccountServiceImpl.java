package supernova.easybudget.accounts.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supernova.easybudget.accounts.domain.model.Account;
import supernova.easybudget.accounts.domain.model.AccountRepository;
import supernova.easybudget.accounts.infrastructure.entities.AccountEntity;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Optional<Account> findById(Long accountId) {
        return repository.findById(accountId);
    }

    @Override
    public List<Account> findAllAccounts() {
        return repository.findAll();
    }


}
