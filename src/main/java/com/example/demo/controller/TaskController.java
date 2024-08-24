package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.execption.NotFoundException;
import com.example.demo.model.TaskCreteTaskModel;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/taskmanagement")
public class TaskController {
	
	@Autowired
	private TaskService TaskserviceApi;
	
	@CrossOrigin("*")
	@PostMapping("/createtask")
	public TaskCreteTaskModel createtask(@RequestBody TaskCreteTaskModel model) throws NotFoundException {
		return TaskserviceApi.createtask(model);
	}
	
	
	@CrossOrigin("*")
	@GetMapping("/viewTask")
	public List<TaskCreteTaskModel> viewtask(@RequestBody TaskCreteTaskModel model) throws NotFoundException {
	    return TaskserviceApi.viewtask(model);
	}
	
	@CrossOrigin("*")
	@PutMapping("/updatetask")
	public TaskCreteTaskModel updatetask(@RequestBody TaskCreteTaskModel model) throws NotFoundException {
	    return TaskserviceApi.updatetask(model);
	}

}
