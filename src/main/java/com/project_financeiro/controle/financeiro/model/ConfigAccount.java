package com.project_financeiro.controle.financeiro.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Table(name = "configuracao_conta")
@Entity
public class ConfigAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "salario")
    @NotNull(message = "O salario é obrigatório")
    private BigDecimal salary;

    @Column(name = "qtde_parcela")
    private Long amountInstallment;

    @Column(name = "qtde_parcela_pagas")
    private Long amountInstallmentPay;

    @Column(name = "valor_parcela")
    private BigDecimal valueInstallment;

    @NotNull(message = "O id da categoria é obrigatório")
    @Column(name = "categoria_id")
    private Long categoryId;


}
