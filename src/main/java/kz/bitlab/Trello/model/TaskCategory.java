package kz.bitlab.Trello.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TaskCategories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;
}
