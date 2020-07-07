package supernova.easybudget.accounts.view.support.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import supernova.easybudget.accounts.domain.model.Account;
import supernova.easybudget.accounts.view.AccountEndpoint;
import supernova.easybudget.accounts.view.support.resources.AccountResource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountResourceAssembler extends RepresentationModelAssemblerSupport<Account, AccountResource> {

    public AccountResourceAssembler() {
        super(AccountEndpoint.class, AccountResource.class);
    }

    @Override
    public AccountResource toModel(Account entity) {
        AccountResource resource = new AccountResource();
        resource.setName(entity.getName());
        resource.setCurrency(entity.getCurrency());
        resource.setValue(entity.getValue());
        resource.setNotes(entity.getNotes());
        resource.add(linkTo(methodOn(AccountEndpoint.class).findById(entity.getId())).withSelfRel());
        return resource;
    }

}
