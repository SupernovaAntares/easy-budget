package supernova.easybudget.transactions.domain.model;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    Optional<Transaction> findById(Long transactionId);

    List<Transaction> findAll();

    public Transaction insert(Transaction transaction);

    public Transaction update(Long transactionId, Transaction transaction);
}
