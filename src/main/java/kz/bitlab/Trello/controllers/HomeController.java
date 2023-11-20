package kz.bitlab.Trello.controllers;

import kz.bitlab.Trello.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    FolderService folderService;

    @GetMapping("/")
    public String mainPage(Model model) {
        var folders = folderService.getAllFolders();
        model.addAttribute("folders", folders);
        return "main";
    }

}
