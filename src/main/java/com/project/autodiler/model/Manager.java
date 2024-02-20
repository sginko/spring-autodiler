package com.project.autodiler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String passportId;

    private int experience;

    private int sales;

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private List<Sale> salesList;
}
