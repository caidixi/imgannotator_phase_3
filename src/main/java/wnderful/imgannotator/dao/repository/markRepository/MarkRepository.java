package wnderful.imgannotator.dao.repository.markRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.mark.Mark;

public interface MarkRepository extends JpaRepository<Mark,Long> {
}
