package com.example.demo.schedular;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.TaskCreateTaskRepo;
import com.example.demo.Repo.TaskUserRegisterRepo;
import com.example.demo.model.TaskCreteTaskModel;
import com.example.demo.model.TaskUserRegisterModel;

@Service
public class TaskScheduler implements EmailService {

    @Autowired
    private TaskCreateTaskRepo taskCreateTaskRepo;

    @Autowired
    private TaskUserRegisterRepo taskUserRegisterRepo;

    @Autowired
    private JavaMailSender mailSender; // Ensure this bean is auto-configured

    @Scheduled(cron = "0 * * * * *") // Every minute
    @Override
    public void checkAndSendEmailAlerts() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);

        List<TaskCreteTaskModel> tasks = taskCreateTaskRepo.findByTaskdateAndTaskTime(currentDate, currentTime);

        for (TaskCreteTaskModel task : tasks) {
            TaskUserRegisterModel user = taskUserRegisterRepo.findById(task.getUserid()).orElse(null);
            if (user != null) {
                sendEmail(task, user);
                System.out.println("done your mail send sucessfully "+task.getTaskname());
            } else {
                System.out.println("No user found for user ID: " + task.getUserid());
            }
        }
    }

    private void sendEmail(TaskCreteTaskModel task, TaskUserRegisterModel user) {
    	System.out.println(user.getEmail());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("saranoffice@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("Your task: " + task.getTaskname());
        message.setText("Hi, this is a reminder for your task: " + task.getTaskname());

        mailSender.send(message);
    }
}
