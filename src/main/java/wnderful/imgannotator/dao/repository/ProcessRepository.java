package wnderful.imgannotator.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.imgannotator.dao.entity.Process;

public interface ProcessRepository extends JpaRepository<Process,Long> {

    Process[] findProcessByWorkerUsername(String username);

    Process[] findProcessByWorkerUsernameAndIsCompleted(String username,int isCompleted);

    Process[] findProcessByTaskNameAndIsCompleted(String name,int isCompleted);

    Process[] findProcessByWorkerUsernameAndIsCompletedAndTaskIsEnd(String username,int isCompleted,int isEnd);

    Process findProcessByWorkerUsernameAndTaskName(String username,String name);
}
