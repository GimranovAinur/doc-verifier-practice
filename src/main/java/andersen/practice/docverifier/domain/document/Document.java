package andersen.practice.docverifier.domain.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Document {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String path;

    private LocalDateTime timeReceived;

    private LocalDateTime timeFinished;

    @OneToMany(mappedBy = "document",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Field> fields;

}
