package supernova.easybudget.transactions.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supernova.easybudget.transactions.domain.model.Transaction;
import supernova.easybudget.transactions.domain.model.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository repository;

    @Override
    public Optional<Transaction> findById(Long transactionId) {
        return repository.findById(transactionId);
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return repository.findAll();
    }

    @Override
    public Transaction insert(Transaction transaction) {
        return repository.insert(transaction);
    }

    @Override
    public Transaction update(Long transactionId, Transaction transaction) {
        return repository.update(transactionId, transaction);
    }
}
