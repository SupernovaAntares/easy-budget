package supernova.easybudget.transactions.infrastructure.entities.enums.converter;

import supernova.easybudget.transactions.infrastructure.entities.enums.TransactionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<TransactionType, String> {
    @Override
    public String convertToDatabaseColumn(TransactionType transactionType) {
        if (transactionType == null) {
            return null;
        }
        return transactionType.toString();
    }

    @Override
    public TransactionType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(TransactionType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

