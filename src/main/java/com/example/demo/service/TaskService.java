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
    private TaskCreateTaskRepo taskCreateTaskRepo;

    @Autowired
    private TaskUserRegisterRepo taskUserRegisterRepo;

    public TaskCreteTaskModel createtask(TaskCreteTaskModel model) throws NotFoundException {
        TaskUserRegisterModel user = taskUserRegisterRepo.findById(model.getUserid()).orElse(null);
        if (user != null) {
            System.out.println("taskTime: " + model.getTaskTime());
            return taskCreateTaskRepo.save(model);
        } else {
            throw new NotFoundException("No User Id!");
        }
    }

    public List<TaskCreteTaskModel> viewtask(int userId) throws NotFoundException {
        List<TaskCreteTaskModel> tasks = taskCreateTaskRepo.findByUserid(userId);
        if (tasks != null && !tasks.isEmpty()) {
            return tasks;
        } else {
            throw new NotFoundException("No tasks found for user Id: " + userId);
        }
    }

    public TaskCreteTaskModel updatetask(TaskCreteTaskModel model) throws NotFoundException {
        TaskCreteTaskModel existingTask = taskCreateTaskRepo.findById(model.getId()).orElse(null);
        if (existingTask != null) {
            existingTask.setTaskdate(model.getTaskdate());
            existingTask.setTaskname(model.getTaskname());
            existingTask.setTaskTime(model.getTaskTime());
            return taskCreateTaskRepo.save(existingTask);
        } else {
            throw new NotFoundException("No Task Found with id: " + model.getId());
        }
    }
}
