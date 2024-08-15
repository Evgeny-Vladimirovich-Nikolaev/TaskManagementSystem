package org.example.model;

import lombok.*;

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
    @Setter
    private Long id;

    @NotEmpty
    @JoinColumn(name = "person_id")
    @OneToOne
    @Getter
    @Setter
    private Person person;


    @OneToMany(mappedBy = "performer", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Task> taskList;

}
