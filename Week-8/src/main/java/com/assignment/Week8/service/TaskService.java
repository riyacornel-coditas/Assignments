package com.assignment.Week8.service;

import com.assignment.Week8.aspects.ActivityLoggingAspect;
import com.assignment.Week8.dto.TaskCreate;
import com.assignment.Week8.dto.UpdatePriority;
import com.assignment.Week8.dto.UpdateStatus;
import com.assignment.Week8.entity.Tasks;
import com.assignment.Week8.enums.Priority;
import com.assignment.Week8.enums.Status;
import com.assignment.Week8.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Tasks createTask(TaskCreate taskCreate)
    {
        Tasks task = new Tasks();
        task.setEmployeeName(taskCreate.getEmployeeName());
        task.setEmployeeEmail(taskCreate.getEmployeeEmail());
        task.setTaskTitle(taskCreate.getTaskTitle());
        task.setPriority(taskCreate.getPriority());
        task.setCreatedDate(LocalDateTime.now());
        task.setUpdatedDate(LocalDateTime.now());
        task.setTaskDescription(taskCreate.getTaskDescription());
        task.setStatus(Status.valueOf(taskCreate.getStatus()));
        task.setRole(taskCreate.getRole());

        taskRepository.save(task);

        return task;
    }

    public List<Tasks> getAll()
    {
        return taskRepository.findAll();
    }

    public Tasks getById(Long id)
    {
        return taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));

    }

    public Tasks updateStatus(UpdateStatus status)
    {
        Tasks task = taskRepository.findById(status.getId())
                .orElseThrow(()-> new RuntimeException("Task not found"));

        task.setStatus(status.getStatus());
        task.setUpdatedDate(LocalDateTime.now());

        return taskRepository.save(task);

    }

    public Tasks updatePriority(UpdatePriority priority)
    {
        Tasks task = taskRepository.findById(priority.getId())
                .orElseThrow(()-> new RuntimeException("Task not found"));

        task.setPriority(priority.getPriority());
        task.setUpdatedDate(LocalDateTime.now());

        return taskRepository.save(task);
    }

    public List<Tasks> getByEmail(String email)
    {
        return taskRepository.findByEmployeeEmail(email);
    }

    public List<Tasks> getByStatus(String status)
    {
        return taskRepository.findByStatus(Status.valueOf(status.toUpperCase()));
    }

    public List<Tasks> getByPriority(String priority)
    {
        return taskRepository.findByPriority(Priority.valueOf(priority.toUpperCase()));
    }

    public String deleteTask(Long id)
    {
        taskRepository.deleteById(id);
        return "Task deleted";
    }

}
