package supernova.easybudget.transactions.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import supernova.easybudget.transactions.domain.model.Transaction;
import supernova.easybudget.transactions.domain.model.TransactionRepository;
import supernova.easybudget.transactions.infrastructure.entities.TransactionEntity;
import supernova.easybudget.transactions.infrastructure.entities.enums.TransactionCategory;
import supernova.easybudget.transactions.infrastructure.entities.enums.TransactionType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TransactionRepositoryDatabase implements TransactionRepository {

    @Autowired
    private TransactionRepositoryH2 springRepository;

    @Override
    public Optional<Transaction> findById(Long transactionId) {
        Optional<TransactionEntity> entity = springRepository.findById(transactionId);
        return entity.map(this::toModel);
    }

    @Override
    public List<Transaction> findAll() {
        return springRepository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Transaction insert(Transaction transaction) {
        return toModel(springRepository.save(toEntity(transaction)));
    }

    @Override
    public Transaction update(Long transactionId, Transaction transaction) {
        TransactionEntity transactionEntity = springRepository.getOne(transactionId);
        updatedata(transactionEntity, transaction);
        return toModel(springRepository.save(transactionEntity));
    }

    public void updatedata(TransactionEntity transactionEntity, Transaction transaction){
        transactionEntity.setAccountId(transaction.getAccountId());
        transactionEntity.setTransactionValue(transaction.getValue());
        transactionEntity.setTransactionType(TransactionType.valueOf(transaction.getType()));
        transactionEntity.setTransactionCategory(TransactionCategory.valueOf(transaction.getCategory()));
        transactionEntity.setFrom(transaction.getFrom());
        transactionEntity.setNotes(transaction.getNotes());
    }

    private TransactionEntity toEntity(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(transaction.getId());
        transactionEntity.setAccountId(transaction.getAccountId());
        transactionEntity.setTransactionValue(transaction.getValue());
        transactionEntity.setTransactionType(TransactionType.valueOf(transaction.getType()));
        transactionEntity.setTransactionCategory(TransactionCategory.valueOf(transaction.getCategory()));
        transactionEntity.setFrom(transaction.getFrom());
        transactionEntity.setNotes(transaction.getNotes());
        return transactionEntity;
    }

    private Transaction toModel(TransactionEntity transactionEntity) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionEntity.getId());
        transaction.setAccountId(transactionEntity.getAccountId());
        transaction.setValue(transactionEntity.getTransactionValue());
        transaction.setType(transactionEntity.getTransactionType().getCode());
        transaction.setCategory(transactionEntity.getTransactionCategory().getCode());
        transaction.setFrom(transactionEntity.getFrom());
        transaction.setNotes(transactionEntity.getNotes());
        return transaction;
    }
}
