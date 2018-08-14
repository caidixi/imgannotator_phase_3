package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Img;

public interface ImgRepository extends JpaRepository<Img,Long> {
    Img findImgByTaskNameAndImgName(String name,String imgName);

    Img[] findImgByTaskName(String name);
}
