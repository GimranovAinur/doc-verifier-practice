package andersen.practice.docverifier.service.impl;

import andersen.practice.docverifier.domain.document.Field;
import andersen.practice.docverifier.repository.document.FieldRepositoryCustom;
import andersen.practice.docverifier.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl implements FieldService {

    private FieldRepositoryCustom fieldRepository;

    @Autowired
    public FieldServiceImpl(FieldRepositoryCustom fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    @Override
    public Field getEarliestUnverifiedField() {
        return fieldRepository.findEarliestUnverifiedField();
    }
}
