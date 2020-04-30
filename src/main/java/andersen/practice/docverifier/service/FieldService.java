package andersen.practice.docverifier.service;

import andersen.practice.docverifier.domain.document.Field;

public interface FieldService {

    Field getEarliestUnverifiedField();

}
