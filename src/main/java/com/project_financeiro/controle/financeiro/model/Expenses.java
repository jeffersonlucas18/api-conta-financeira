package com.project_financeiro.controle.financeiro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Table(name = "despesas")
@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo name é obrigatório")
    @Column(name = "nome")
    private String name;

    @NotNull(message = "O campo value é obrigatório")
    @Column(name = "valor")
    private BigDecimal value;

    @Column(name = "status")
    private String status;

    @NotNull(message = "O campo configAccountId é obrigatório")
    @Column(name = "configuracao_conta_id")
    private Long configAccountId;
}
