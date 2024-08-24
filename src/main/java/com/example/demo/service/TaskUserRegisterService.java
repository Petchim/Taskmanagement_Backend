package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.TaskUserRegisterRepo;
import com.example.demo.model.TaskUserRegisterModel;
import com.face.detection.expception.NotFoundException;

@Service

public class TaskUserRegisterService {

	@Autowired
	private TaskUserRegisterRepo TaskUserRegisterRepoApi;

	public TaskUserRegisterModel userreg(TaskUserRegisterModel model) throws NotFoundException {

		TaskUserRegisterModel usersWithEmail = TaskUserRegisterRepoApi.findByEmail(model.getEmail());
System.out.println(model.getEmail());

		if (usersWithEmail == null) {
			
			return TaskUserRegisterRepoApi.save(model);

		} else {

			throw new NotFoundException("Email already exists!");
		}

	}

	public String userlogin(TaskUserRegisterModel model) throws NotFoundException {

		TaskUserRegisterModel usersWithEmail = TaskUserRegisterRepoApi.findByEmail(model.getEmail());

		if (usersWithEmail != null) {

			if (usersWithEmail.getPassword().equalsIgnoreCase(model.getPassword())) {

			} else {

				throw new NotFoundException("Worng Password For This "+model.getEmail()+"!");
			}
		} else {
			throw new NotFoundException("Email Not Found!");
		}

		return "Login Sucessfull";

	}

}
