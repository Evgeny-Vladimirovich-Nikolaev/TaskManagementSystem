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
@Table(name = "performers")
public class Performer {

    @Id
    @Column(name = "performer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NotEmpty
    @JoinColumn(name = "person_id")
    @Getter
    @OneToOne
    private Person person;


    @OneToMany(mappedBy = "performer", cascade = CascadeType.ALL)
    private List<Task> taskList;

}
