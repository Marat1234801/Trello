package kz.bitlab.Trello.repository;

import kz.bitlab.Trello.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
