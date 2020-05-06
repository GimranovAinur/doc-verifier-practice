package andersen.practice.docverifier.repository.document;

import andersen.practice.docverifier.domain.document.Field;

public interface FieldRepositoryCustom {

    Field findEarliestUnverifiedField();

}
