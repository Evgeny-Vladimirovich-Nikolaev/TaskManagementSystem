package org.example.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")

public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @NotEmpty
    @Column
    @Getter
    @Setter
    private String login;

}
