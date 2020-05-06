package andersen.practice.docverifier.repository.document;

import andersen.practice.docverifier.domain.document.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, String>, FieldRepositoryCustom {

    @Query(value = "select f.* from field as f " +
            "left join document d on f.document_id = d.id " +
            "where verifiers_amount <= 3 and status != 'VERIFIED' " +
            "order by d.time_received " +
            "limit 1", nativeQuery = true)
    Field findEarliestUnverifiedFieldNative();

}
