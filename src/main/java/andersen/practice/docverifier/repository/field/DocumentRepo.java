package andersen.practice.docverifier.repository.field;

import andersen.practice.docverifier.domain.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentRepo extends JpaRepository<Document, String> {
}
