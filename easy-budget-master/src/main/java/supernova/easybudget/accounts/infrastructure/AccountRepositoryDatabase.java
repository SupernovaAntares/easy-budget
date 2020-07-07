package supernova.easybudget.accounts.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import supernova.easybudget.accounts.domain.model.Account;
import supernova.easybudget.accounts.domain.model.AccountRepository;
import supernova.easybudget.accounts.infrastructure.entities.AccountEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AccountRepositoryDatabase implements AccountRepository {

    @Autowired
    private AccountRepositoryH2 springRepository;

    @Override
    public Optional<Account> findById(Long accountId) {
        Optional<AccountEntity> entity = springRepository.findById(accountId);
        return entity.map(value -> {
            Account account = new Account(value.getId());
            account.setName(value.getName());
            account.setCurrency(value.getCurrency());
            account.setValue(value.getAccountValue());
            account.setNotes(value.getNotes());
            return account;
        });
    }

    @Override
    public List<Account> findAll() {
        return springRepository.findAll().stream().map(value -> {
                    Account account = new Account(value.getId());
                    account.setName(value.getName());
                    account.setCurrency(value.getCurrency());
                    account.setValue(value.getAccountValue());
                    account.setNotes(value.getNotes());
                    return account;
                }).collect(Collectors.toList());
    }


}




