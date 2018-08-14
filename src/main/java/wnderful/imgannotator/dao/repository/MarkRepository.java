package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Mark;

public interface MarkRepository extends JpaRepository<Mark,Long> {
}
