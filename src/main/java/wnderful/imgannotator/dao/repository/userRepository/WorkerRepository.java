package wnderful.imgannotator.dao.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.user.Worker;

public interface WorkerRepository extends JpaRepository<Worker,Long> {

    Worker findWorkerByUsername(String username);

}
