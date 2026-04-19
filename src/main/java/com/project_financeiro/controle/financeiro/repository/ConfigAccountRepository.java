package com.project_financeiro.controle.financeiro.repository;

import com.project_financeiro.controle.financeiro.model.ConfigAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigAccountRepository extends JpaRepository<ConfigAccount, Long> {

}
