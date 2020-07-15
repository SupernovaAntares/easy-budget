package supernova.easybudget.accounts.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supernova.easybudget.accounts.application.AccountService;


import supernova.easybudget.accounts.view.support.assemblers.AccountResourceAssembler;
import supernova.easybudget.accounts.view.support.resources.AccountResource;

@RestController
public class AccountEndpoint {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountResourceAssembler assembler;

    @GetMapping("/accounts/{accountId}")
    public AccountResource findById(@PathVariable Long accountId) {
        return service.findById(accountId)
                .map(account -> assembler.toModel(account))
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @GetMapping("/accounts")
    public CollectionModel<AccountResource> findAll() {
        return assembler.toCollectionModel(service.findAllAccounts());

    }

    @PostMapping("/accounts")
    public AccountResource insert(@RequestBody AccountResource accountResource){
        return assembler.toModel(service.insert(assembler.toEntity(accountResource)));
    }

    @PutMapping("/accounts/{accountId}")
    public  AccountResource update(@PathVariable Long accountId, @RequestBody AccountResource accountResource){
        return assembler.toModel(service.update(accountId, assembler.toEntity(accountResource)));
    }

    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<Void> delete(@PathVariable Long accountId){
        service.delete(accountId);
        return ResponseEntity.noContent().build();
    }

}
