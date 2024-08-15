package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private Long id;

    @NotEmpty
    @JoinColumn(name = "person_id")
    @Getter
    @OneToOne
    private Person person;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Task> taskList;


}
