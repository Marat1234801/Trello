package kz.bitlab.Trello.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Folders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    List<TaskCategory> categories;
}
