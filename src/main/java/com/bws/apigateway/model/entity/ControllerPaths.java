package com.bws.apigateway.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "controller_paths")
@Getter
@Setter

public class ControllerPaths {
    @Id
    @Column(name = "contoller_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int controllerId;

    @Column(name = "parent_id")
    @JoinColumn(name = "controller_id")
    private int parentId;

    @Column(name = "path_name")
    private String pathName;

    @OneToMany(mappedBy = "parentId",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<ControllerPaths> children;

    @Column(name = "status")
    private String status;

}
