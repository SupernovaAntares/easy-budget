package supernova.easybudget.accounts.view.support.resources;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value = "account", collectionRelation = "accounts")
public class AccountResource extends RepresentationModel<AccountResource> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
