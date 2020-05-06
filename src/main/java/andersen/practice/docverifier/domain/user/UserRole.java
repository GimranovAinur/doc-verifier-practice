package andersen.practice.docverifier.domain.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_role")
@Data
public class UserRole {

    @Id
    private String code;

}
