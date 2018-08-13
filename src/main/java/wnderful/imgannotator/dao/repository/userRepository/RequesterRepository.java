package wnderful.imgannotator.dao.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.user.Requester;

public interface RequesterRepository extends JpaRepository<Requester,Long> {
    Requester findRequesterByUsername(String username);
}
