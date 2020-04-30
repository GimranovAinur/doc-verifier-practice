package andersen.practice.docverifier.repository.field;

import andersen.practice.docverifier.domain.document.Field;

public interface FieldRepositoryCustom {

    Field findEarliestUnverifiedField();

}
