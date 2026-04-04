package com.project_financeiro.controle.financeiro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Table(name = "despesas")
@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "valor")
    private BigDecimal value;

    @Column(name = "status")
    private String status;


    @Column(name = "configuracao_conta_id")
    private Long configAccountId;
}
