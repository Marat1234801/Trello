package kz.bitlab.Trello.repository;

import kz.bitlab.Trello.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
