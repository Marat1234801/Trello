package kz.bitlab.Trello.controllers;

import kz.bitlab.Trello.enums.Status;
import kz.bitlab.Trello.model.Task;
import kz.bitlab.Trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/task/{taskId}")
    public String getTask(@PathVariable Long taskId, Model model) {
        var task = taskService.getTaskById(taskId);
        if (task != null) {
            List<Status> statuses = Arrays.asList(Status.values());
            model.addAttribute("task", task);
            model.addAttribute("statuses", statuses);
        }
        return "taskDetails";
    }

    @PostMapping("/task/update")
    public String updateTask(Task task) {
        taskService.updateTask(task);
        return "redirect:/folder/details/" + task.getFolder().getId();
    }
}
