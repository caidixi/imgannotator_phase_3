package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Img;

import java.util.List;

public interface ImgRepository extends JpaRepository<Img,Long> {
    Img findImgByTaskNameAndImgName(String name,String imgName);

    Img[] findImgByTaskName(String name);

    List<Img> findImgByIdIsNotNull();
}
