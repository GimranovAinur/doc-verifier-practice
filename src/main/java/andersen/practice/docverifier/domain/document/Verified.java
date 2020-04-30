package andersen.practice.docverifier.domain.document;

import andersen.practice.docverifier.domain.user.User;
import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Verified {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    private Field field;

    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verified_by")
    private User verifiedBy;

    private LocalDateTime timeReceived;

    private LocalDateTime timeFinished;

}
