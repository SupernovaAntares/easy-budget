package supernova.easybudget.transactions.view.support.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import supernova.easybudget.transactions.domain.model.Transaction;
import supernova.easybudget.transactions.view.TransactionEndPoint;
import supernova.easybudget.transactions.view.support.resources.TransactionResource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TransactionResourceAssembler extends RepresentationModelAssemblerSupport<Transaction, TransactionResource> {

    public TransactionResourceAssembler() {
        super(TransactionEndPoint.class, TransactionResource.class);
    }

    @Override
    public TransactionResource toModel(Transaction entity) {
        TransactionResource resource = new TransactionResource();
        resource.setId(entity.getId());
        resource.setAccountId(entity.getAccountId());
        resource.setValue(entity.getValue());
        resource.setType(entity.getType());
        resource.setCategory(entity.getCategory());
        resource.setFrom(entity.getFrom());
        resource.setNotes(entity.getNotes());
        resource.add(linkTo(methodOn(TransactionEndPoint.class).findById(entity.getId())).withSelfRel());
        return resource;
    }

    public Transaction toEntity(TransactionResource transactionResource){
        Transaction transaction = new Transaction(transactionResource.getId());
        transaction.setAccountId(transactionResource.getAccountId());
        transaction.setType(transactionResource.getType());
        transaction.setCategory(transactionResource.getCategory());
        transaction.setValue(transactionResource.getValue());
        transaction.setFrom(transactionResource.getFrom());
        transaction.setNotes(transactionResource.getNotes());
        return transaction;
    }

}
