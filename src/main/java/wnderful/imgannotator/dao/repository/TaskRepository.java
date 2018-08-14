package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

    Task findTaskByNameAndIsDraft(String name,int isDraft);

    Task findTaskByNameAndIsEnd(String name,int isEnd);

    Task findTaskByNameAndIsEndAndIsDraft(String name,int isEnd,int isDraft);

    Task[] findTaskByIsDraft(int isDraft);

    Task[] findTaskByRequesterUsernameAndIsDraft(String username,int isDraft);

    Task[] findTaskByIsDraftAndIsEnd(int isDraft,int isEnd);

    Task[] findTaskByIsDraftAndIsEndAndNameNotIn(int isDraft,int isEnd,String[] name);

    Task[] findTaskByRequesterUsernameAndIsDraftAndIsEnd(String username,int isDraft,int isEnd);

}
