package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Work;

public interface WorkRepository extends JpaRepository<Work,Long> {
}
