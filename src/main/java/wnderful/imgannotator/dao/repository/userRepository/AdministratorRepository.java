package wnderful.imgannotator.dao.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.user.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator,Long> {
    Administrator findAdministratorByUsername(String username);
}
