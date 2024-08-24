package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.TaskCreateTaskRepo;
import com.example.demo.Repo.TaskUserRegisterRepo;
import com.example.demo.execption.NotFoundException;
import com.example.demo.model.TaskCreteTaskModel;
import com.example.demo.model.TaskUserRegisterModel;
@Service

public class TaskService {
	
	@Autowired
	private TaskCreateTaskRepo TaskCreateTaskRepoApi;
	
	@Autowired
	private TaskUserRegisterRepo TaskUserRegisterModelApi;

	public TaskCreteTaskModel createtask(TaskCreteTaskModel model) throws NotFoundException {
		
		TaskUserRegisterModel userid=TaskUserRegisterModelApi.findById(model.getUserid()).orElse(null);
		if(userid!=null) {
		System.out.println("taskTime: "+model.getTaskTime());
	
		return TaskCreateTaskRepoApi.save(model);
		}else {
			throw new NotFoundException("No User Id!");
		}
		
	}

	public List<TaskCreteTaskModel> viewtask(TaskCreteTaskModel model) throws NotFoundException {
	
		List<TaskCreteTaskModel> userid=TaskCreateTaskRepoApi.findByUserid(model.getUserid());
		if(userid!=null) {
			
			return userid;
		}else {
		
			throw new NotFoundException("No User Id !");
		}
		
		
	}

	public TaskCreteTaskModel updatetask(TaskCreteTaskModel model) throws NotFoundException {
		
		TaskCreteTaskModel taskid=TaskCreateTaskRepoApi.findById(model.getId()).orElse(null);
		if(taskid!=null) {
			taskid.setTaskdate(model.getTaskdate());
			taskid.setTaskname(model.getTaskname());
			taskid.setTaskTime(model.getTaskTime());
			return TaskCreateTaskRepoApi.save(taskid);
		}else {
			throw new NotFoundException("No Task Found !");
		}
		
	}

	
}
