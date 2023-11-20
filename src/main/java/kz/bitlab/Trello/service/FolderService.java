package kz.bitlab.Trello.service;

import kz.bitlab.Trello.model.Folder;
import kz.bitlab.Trello.repository.FolderRepository;
import kz.bitlab.Trello.repository.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private TaskCategoryRepository categoryRepository;

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public Folder getFolderById(Long id) {
        return folderRepository.findById(id).orElse(null);
    }

    public void createFolder(Folder folder) {
        if (!folder.getName().isEmpty()) {
            folderRepository.save(folder);
        } else {
            return;
        }
    }

    public void addCategoryToFolder(Long folderId, Long categoryId) {
        var folder = folderRepository.findById(folderId).orElse(null);
        var category = categoryRepository.findById(categoryId).orElse(null);
        if (folder == null || category == null) {
            return;
        }
        folder.getCategories().add(category);
        folderRepository.save(folder);
    }

    public void removeCategoryFromFolder(Long folderId, Long categoryId) {
        var folder = folderRepository.findById(folderId).orElse(null);
        var category = categoryRepository.findById(categoryId).orElse(null);
        if (folder == null) {
            return;
        }
        folder.getCategories().removeIf(category1 -> Objects.equals(category, category1));
        folderRepository.save(folder);
    }
}
