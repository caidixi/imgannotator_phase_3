package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Code;

public interface CodeRepository extends JpaRepository<Code,Long> {
}
