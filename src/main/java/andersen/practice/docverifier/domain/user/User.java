package andersen.practice.docverifier.domain.user;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role")
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "status")
    private UserStatus status;

}
