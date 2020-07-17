package supernova.easybudget.transactions.infrastructure.entities.enums.converter;

import supernova.easybudget.transactions.infrastructure.entities.enums.TransactionCategory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<TransactionCategory, String> {

    @Override
    public String convertToDatabaseColumn(TransactionCategory transactionCategory) {
        if (transactionCategory == null) {
            return null;
        }
        return transactionCategory.toString();
    }

    @Override
    public TransactionCategory convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(TransactionCategory.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
