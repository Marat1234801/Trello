package kz.bitlab.Trello.service;

import kz.bitlab.Trello.model.TaskCategory;
import kz.bitlab.Trello.repository.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoryService {
    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    public List<TaskCategory> getAllCategories(){
        return taskCategoryRepository.findAll();
    }

    public TaskCategory getCategoryById(Long id){
        return taskCategoryRepository.findById(id).orElse(null);
    }
}
