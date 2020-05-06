package andersen.practice.docverifier.repository.user;

import andersen.practice.docverifier.domain.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {

    UserRole findByCode(String code);

}
