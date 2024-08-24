package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaskUserRegisterModel;
import com.example.demo.service.TaskUserRegisterService;
import com.face.detection.expception.NotFoundException;


@RestController
@RequestMapping("/taskmanagement")

public class TaskUserRegisterController {
	
	@Autowired
	private TaskUserRegisterService TaskUserRegisterServiceApi;
	@CrossOrigin("*")
	@PostMapping("/userregister")
	public TaskUserRegisterModel user(@RequestBody TaskUserRegisterModel model ) throws NotFoundException
	{
		return TaskUserRegisterServiceApi.userreg(model);
	}
	
	//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- login =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	
	@CrossOrigin("*")
	@PostMapping("/userlogin")
	public String userlogin(@RequestBody TaskUserRegisterModel model ) throws NotFoundException
	{
		return TaskUserRegisterServiceApi.userlogin(model);
	}
	
	

}
