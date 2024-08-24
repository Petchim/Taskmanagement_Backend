package com.example.demo.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TaskUserRegisterModel;

public interface TaskUserRegisterRepo extends JpaRepository<TaskUserRegisterModel , Integer>{



	TaskUserRegisterModel findByEmail(String email);

	



}
