package com.assignment.Week8.controller;

import com.assignment.Week8.aspects.ActivityLogStore;
import com.assignment.Week8.dto.TaskCreate;
import com.assignment.Week8.dto.UpdatePriority;
import com.assignment.Week8.dto.UpdateStatus;
import com.assignment.Week8.entity.Tasks;
import com.assignment.Week8.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final ActivityLogStore logStore;

    @PostMapping("/create")
    public Tasks createTask(@RequestBody TaskCreate taskCreate)
    {
        return taskService.createTask(taskCreate);
    }

    @GetMapping("/get/alltasks")
    public List<Tasks> getAll()
    {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Tasks getById(@PathVariable Long id)
    {
        return taskService.getById(id);
    }

    @PutMapping("/update/status")
    public Tasks updateStatus(@RequestBody UpdateStatus status)
    {
        return taskService.updateStatus(status);
    }

    @PutMapping("/update/priority")
    public Tasks updatePriority(@RequestBody UpdatePriority priority)
    {
        return taskService.updatePriority(priority);
    }

    @GetMapping("/get/by/email")
    public List<Tasks> getByEmail(@RequestParam String email)
    {
        return taskService.getByEmail(email);
    }

    @GetMapping("/get/by/status")
    public List<Tasks> getByStatus(@RequestParam String status)
    {
        return taskService.getByStatus(status);
    }

    @GetMapping("/get/by/priority")
    public List<Tasks> getByPriority(@RequestParam String priority)
    {
        return taskService.getByPriority(priority);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id)
    {
        return taskService.deleteTask(id);
    }

    @GetMapping("/activity/logs")
    public List<String> getActivityLogs()
    {
        return logStore.getLogs();
    }


}
