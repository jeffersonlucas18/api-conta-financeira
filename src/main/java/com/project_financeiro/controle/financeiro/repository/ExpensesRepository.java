package com.project_financeiro.controle.financeiro.repository;

import com.project_financeiro.controle.financeiro.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    List<Expenses> findAllByConfigAccountId(Long configAccountId);
}
