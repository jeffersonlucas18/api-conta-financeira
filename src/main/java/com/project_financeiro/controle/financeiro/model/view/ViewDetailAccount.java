package com.project_financeiro.controle.financeiro.model.view;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.math.BigDecimal;

@Entity
@Immutable
@Subselect("""
CREATE OR REPLACE VIEW view_detalhe_contas AS SELECT cc.id, u.nome AS userName, cc.nome AS name, c.nome AS category, cc.salario AS salary, cc.qtde_parcela AS amountInstallment, cc.qtde_parcela_pagas AS amountInstallmentPay, cc.valor_parcela AS valueInstallment, SUM(CASE WHEN d.status = 'PENDENTE' THEN d.valor ELSE 0 END) AS expenseTotalPending, SUM(CASE WHEN d.status = 'PAGO' THEN d.valor ELSE 0 END) AS expenseTotalPaid, SUM(d.valor) AS expenseTotal FROM configuracao_conta cc JOIN categorias c ON c.id = cc.categoria_id JOIN users u ON u.id = cc.user_id JOIN despesas d ON d.configuracao_conta_id = cc.id GROUP BY cc.id, u.nome, cc.nome, c.nome, cc.salario, cc.qtde_parcela, cc.qtde_parcela_pagas, cc.valor_parcela;
""")
public class ViewDetailAccount {
    @Id
    private Long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "amountInstallment")
    private BigDecimal amountInstallment;
    @Column(name = "amountInstallmentPay")
    private BigDecimal amountInstallmentPay;
    @Column(name = "valueInstallment")
    private BigDecimal valueInstallment;
    @Column(name = "expenseTotalPending")
    private BigDecimal expenseTotalPending;
    @Column(name = "expenseTotalPaid")
    private BigDecimal expenseTotalPaid;
    @Column(name = "expenseTotal")
    private BigDecimal expenseTotal;

}
