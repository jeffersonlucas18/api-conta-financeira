package com.project_financeiro.controle.financeiro.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "categorias")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;
}
