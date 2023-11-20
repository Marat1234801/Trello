package kz.bitlab.Trello.controllers;

import kz.bitlab.Trello.model.Folder;
import kz.bitlab.Trello.model.Task;
import kz.bitlab.Trello.service.FolderService;
import kz.bitlab.Trello.service.TaskCategoryService;
import kz.bitlab.Trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FolderController {
    @Autowired
    FolderService folderService;
    @Autowired
    TaskService taskService;
    @Autowired
    TaskCategoryService categoryService;

    @GetMapping("/folder/details/{id}")
    public String getFolder(@PathVariable Long id, Model model) {
        var folder = folderService.getFolderById((id));
        if (folder == null) {
            return "redirect:/";
        }
        var tasks = taskService.getTasksByFolder(id);
        var categories = categoryService.getAllCategories();
        if (categories != null) {
            categories.removeAll(folder.getCategories());
        }
        model.addAttribute("folder", folder);
        model.addAttribute("tasks", tasks);
        model.addAttribute("categories", categories);
        return "folderDetails";
    }

    @PostMapping("/folder/create")
    public String addFolder(Folder folder) {
        folderService.createFolder(folder);
        return "redirect:/";
    }

    @PostMapping("/folder/addCategory")
    public String addCategoryToFolder(@RequestParam Long folderId, @RequestParam Long categoryId) {
        folderService.addCategoryToFolder(folderId, categoryId);
        return "redirect:/folder/details/" + folderId;
    }

    @PostMapping("/folder/addTask")
    public String addTaskToFolder(Task task) {
        taskService.addTaskToFolder(task);
        return "redirect:/folder/details/" + task.getFolder().getId();
    }

    @PostMapping("/folder/{folderId}/deleteCategory")
    public String deleteCategoryFromFolder(@PathVariable Long folderId, @RequestParam Long categoryId) {
        folderService.removeCategoryFromFolder(folderId, categoryId);
        return "redirect:/folder/details/" + folderId;
    }

    @PostMapping("/folder/deleteTask/{taskId}")
    public String deleteTaskFromFolder(@PathVariable Long taskId) {
        var task = taskService.getTaskById(taskId);
        taskService.removeTaskFromFolder(task);
        return "redirect:/folder/details/" + task.getFolder().getId();
    }
}
