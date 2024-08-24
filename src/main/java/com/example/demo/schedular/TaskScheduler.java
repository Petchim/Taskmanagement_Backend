//package com.example.demo.schedular;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.Repo.TaskCreateTaskRepo;
//import com.example.demo.model.TaskCreteTaskModel;
//import com.face.detection.service.EmailService;
//
//@Component
//
//public class TaskScheduler {
//	
//	@Autowired 
//	private TaskCreteTaskModel  TaskCreateTaskModelApi;
//	
//	@Autowired 
//	private EmailService emailservices;
//	
//	@Autowired 
//	private TaskCreateTaskRepo  TaskCreteTaskRepoApi;
//	
//	@Scheduled(cron = "0 * * * * ?")
//	public void CheckAndEmailAlert() {
//	    LocalDate today = LocalDate.now();
//        LocalTime now = LocalTime.now();
//		
//		List<TaskCreteTaskModel> task= TaskCreteTaskRepoApi.findByTaskTimeAndTaskTime(today,now);
//		
//		for(TaskCreteTaskModel tasks:task)
//		{
//            String to = task.getUserEmail(); // User's email
//            String subject = "Task Reminder";
//            String text = "Reminder for your task: " + tasks.getTaskname() +
//                    " scheduled for " + tasks.getTaskTime();
//
//            emailservices.sendSimpleMessage(to, subject, text);
//
//		}
//		
//		
//		
//	}
//	
//
//}
