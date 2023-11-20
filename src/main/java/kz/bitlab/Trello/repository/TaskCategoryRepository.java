package kz.bitlab.Trello.repository;

import kz.bitlab.Trello.model.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
}
