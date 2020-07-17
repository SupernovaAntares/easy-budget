package supernova.easybudget.transactions.application;

import supernova.easybudget.accounts.domain.model.Account;
import supernova.easybudget.transactions.domain.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Optional<Transaction> findById(Long transactionId);

    List<Transaction> findAllTransactions();

    public Transaction insert(Transaction transaction);

    public Transaction update(Long transactionId, Transaction transaction);
}
