package supernova.easybudget.transactions.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import supernova.easybudget.transactions.application.TransactionService;
import supernova.easybudget.transactions.view.support.assemblers.TransactionResourceAssembler;
import supernova.easybudget.transactions.view.support.resources.TransactionResource;


@RestController
public class TransactionEndPoint {

    @Autowired
    private TransactionService service;

    @Autowired
    private TransactionResourceAssembler assembler;

    @GetMapping("/accounts/transaction/{transactionId}")
    public TransactionResource findById(@PathVariable Long transactionId) {
        return service.findById(transactionId)
                .map(transaction -> assembler.toModel(transaction))
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @GetMapping("/accounts/{accountId}/transaction")
    public CollectionModel<TransactionResource> findAll() {
        return assembler.toCollectionModel(service.findAllTransactions());

    }

    @PostMapping("/accounts/{accountId}/transaction")
    public TransactionResource insert(@RequestBody TransactionResource transactionResource){
        return assembler.toModel(service.insert(assembler.toEntity(transactionResource)));
    }

    @PutMapping("/accounts/transaction/{transactionId}")
    public TransactionResource update(@PathVariable Long transactionId, @RequestBody TransactionResource transactionResource){
        return assembler.toModel(service.update(transactionId, assembler.toEntity(transactionResource)));
    }

}
