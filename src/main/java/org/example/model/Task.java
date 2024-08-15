package org.example.model;

import lombok.*;
import org.example.enums.Priority;
import org.example.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @NotEmpty
    @Column
    @Getter
    @Setter
    private String header;

    @NotEmpty
    @Column
    @Getter
    @Setter
    private String description;

    @NotEmpty
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @Getter
    @Setter
    private Author author;

    @NotEmpty
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "performer_id")
    @Getter
    @Setter
    private Performer performer;

    @NotEmpty
    @Column
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Status status;

    @NotEmpty
    @Column
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Priority priority;

}
