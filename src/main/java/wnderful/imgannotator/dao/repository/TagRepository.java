package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
