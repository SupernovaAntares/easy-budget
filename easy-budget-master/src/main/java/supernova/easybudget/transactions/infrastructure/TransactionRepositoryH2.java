package supernova.easybudget.transactions.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import supernova.easybudget.transactions.infrastructure.entities.TransactionEntity;

public interface TransactionRepositoryH2 extends JpaRepository<TransactionEntity, Long> {
}
