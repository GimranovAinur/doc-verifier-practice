package andersen.practice.docverifier.repository.user;

import andersen.practice.docverifier.domain.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<UserStatus, String> {

    UserStatus findByCode(String code);

}
