package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import wnderful.imgannotator.dao.entity.Tag;

import javax.transaction.Transactional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findTagByContentAndTaskName(String content,String name);
    Tag[] findTagByContent(String content);
    Tag[] findTagByTaskIsNull();
    Tag[] findTagByTaskName(String name);

    @Modifying
    @Transactional
    void deleteTagByContent(String content);

    @Modifying
    @Transactional
    void deleteTagByTaskName(String name);
}
