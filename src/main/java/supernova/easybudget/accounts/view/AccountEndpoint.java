package supernova.easybudget.accounts.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
}
