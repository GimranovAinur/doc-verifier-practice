package andersen.practice.docverifier.repository.field;

import andersen.practice.docverifier.domain.document.Field;
import andersen.practice.docverifier.domain.document.FieldStatus;
import andersen.practice.docverifier.domain.document.QDocument;
import andersen.practice.docverifier.domain.document.QField;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class FieldRepositoryImpl implements FieldRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Field findEarliestUnverifiedField() {
        QField field = QField.field;
        QDocument document = QDocument.document;
        return queryFactory.select(field)
                .from(field)
                .leftJoin(document)
                .on(document.id.eq(field.document.id))
                .where(field.verifiersAmount.lt(4)
                        .and(field.status.ne(FieldStatus.VERIFIED)))
                .orderBy(document.timeReceived.asc())
                .fetchFirst();

    }

}
