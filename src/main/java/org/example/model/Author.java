package org.example.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @NotEmpty
    @JoinColumn(name = "person_id")
    @OneToOne
    @Getter
    @Setter
    private Person person;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Task> taskList;


}
