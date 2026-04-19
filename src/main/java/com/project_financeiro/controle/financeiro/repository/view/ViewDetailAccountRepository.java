package com.project_financeiro.controle.financeiro.repository.view;

import com.project_financeiro.controle.financeiro.model.view.ViewDetailAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewDetailAccountRepository extends JpaRepository<ViewDetailAccount, Long> {
}
