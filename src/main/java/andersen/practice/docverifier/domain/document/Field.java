package andersen.practice.docverifier.domain.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Field {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Document document;

    private String value;

    @Enumerated(EnumType.STRING)
    private FieldStatus status;

    private Integer verifiersAmount;

}
