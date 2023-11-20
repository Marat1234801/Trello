package kz.bitlab.Trello.service;

import kz.bitlab.Trello.enums.Status;
import kz.bitlab.Trello.model.Task;
import kz.bitlab.Trello.repository.FolderRepository;
import kz.bitlab.Trello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private FolderRepository folderRepository;

    public List<Task> getTasksByFolder(Long id) {
        var folder = folderRepository.findById(id).orElse(null);
        if (folder != null) {
            return taskRepository.findAllByFolder(folder);
        }
        return null;
    }

    public void addTaskToFolder(Task task) {
        if (task.getTitle().isEmpty() || task.getDescription().isEmpty()) {
            return;
        }
        task.setStatus(Status.TODO);
        taskRepository.save(task);
    }

    public void removeTaskFromFolder(Task task) {
        if (task == null) {
            return;
        }
        taskRepository.delete(task);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public void updateTask(Task task) {
        if (task == null) {
            return;
        }
        taskRepository.save(task);
    }
}
