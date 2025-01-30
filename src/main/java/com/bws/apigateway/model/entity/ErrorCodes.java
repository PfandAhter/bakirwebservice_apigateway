package com.bws.apigateway.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "error_codes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "error")
    private String error;

    @Column(name = "description")
    private String description;

}