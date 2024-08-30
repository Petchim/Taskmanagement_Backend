package com.example.demo.Repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.TaskCreteTaskModel;



@Repository

public interface TaskCreateTaskRepo extends JpaRepository<TaskCreteTaskModel,Integer> {

    List<TaskCreteTaskModel> findByTaskdateAndTaskTime(LocalDate taskdate, LocalTime taskTime);
    List<TaskCreteTaskModel> findByUserid(int userid);

}
