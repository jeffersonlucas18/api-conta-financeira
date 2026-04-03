package com.project_financeiro.controle.financeiro.model;

import jakarta.persistence.*;
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
    private BigDecimal salary;

    @Column(name = "qtde_parcela")
    private Long amountInstallment;

    @Column(name = "qtde_parcela_pagas")
    private Long amountInstallmentPay;

    @Column(name = "valor_parcela")
    private BigDecimal valueInstallment;

    @Column(name = "categoria_id")
    private Long categoryId;


}
