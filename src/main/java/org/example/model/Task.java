package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private Long id;

    @NotEmpty
    @Column
    @Getter
    private String header;

    @NotEmpty
    @Column
    @Getter
    private String description;

    @NotEmpty
    @Getter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @NotEmpty
    @Getter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "performer_id")
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
