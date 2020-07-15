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
        return entity.map(this::toModel);
    }

    @Override
    public List<Account> findAll() {
        return springRepository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Account insert(Account account) {
        return toModel(springRepository.save(toEntity(account)));
    }

    @Override
    public Account update(Long accountId, Account account) {
        AccountEntity accountEntity = springRepository.getOne(accountId);
        updatedata(accountEntity, account);
        return toModel(springRepository.save(accountEntity));
    }

    @Override
    public void delete(Long accountId) {
        springRepository.deleteById(accountId);
    }


    public void updatedata(AccountEntity accountEntity, Account account){
        accountEntity.setName(account.getName());
        accountEntity.setAccountValue(account.getValue());
        accountEntity.setCurrency(account.getCurrency());
        accountEntity.setNotes(account.getNotes());
    }

    private AccountEntity toEntity(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(account.getId());
        accountEntity.setName(account.getName());
        accountEntity.setAccountValue(account.getValue());
        accountEntity.setCurrency(account.getCurrency());
        accountEntity.setNotes(account.getNotes());
        return accountEntity;
    }

    private Account toModel(AccountEntity entity) {
        Account account = new Account(entity.getId());
        account.setName(entity.getName());
        account.setCurrency(entity.getCurrency());
        account.setValue(entity.getAccountValue());
        account.setNotes(entity.getNotes());
        return account;
    }


}




