package com.project_financeiro.controle.financeiro.service;

import com.project_financeiro.controle.financeiro.model.Category;
import com.project_financeiro.controle.financeiro.model.ConfigAccount;
import com.project_financeiro.controle.financeiro.model.Expenses;
import com.project_financeiro.controle.financeiro.repository.CategoryRepository;
import com.project_financeiro.controle.financeiro.repository.ConfigAccountRepository;
import com.project_financeiro.controle.financeiro.repository.ExpensesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private final CategoryRepository categoryRepository;
    private final ConfigAccountRepository configAccountRepository;
    private final ExpensesRepository expensesRepository;

    public PriceService(CategoryRepository categoryRepository, ConfigAccountRepository configAccountRepository, ExpensesRepository expensesRepository) {
        this.categoryRepository = categoryRepository;
        this.configAccountRepository = configAccountRepository;
        this.expensesRepository = expensesRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Page<ConfigAccount> getAccounts(Pageable pageable) {
        return configAccountRepository.findAll(pageable);
    }

    public Optional<ConfigAccount> getAccount(Long id) {
        return configAccountRepository.findById(id);
    }

    public ConfigAccount setAccount(ConfigAccount configAccount) {
        ConfigAccount account = configAccountRepository.save(configAccount);
        if (account.getCategoryId().equals(2L)) {
            List<Expenses> expenses = new ArrayList<>();

            // PENDENTES
            Long amountInstallmentPeding = account.getAmountInstallment() - account.getAmountInstallmentPay();
            for (int i = 1; i <= amountInstallmentPeding; i++) {
                Expenses expense = new Expenses();
                expense.setName("Cobrança - ".concat(String.valueOf(i)));
                expense.setValue(account.getValueInstallment());
                expense.setStatus("PENDENTE");
                expense.setConfigAccountId(account.getId());
                expenses.add(expense);
            }

            // PAGOS
            for (int i = 1; i <= account.getAmountInstallmentPay(); i++) {
                Expenses expense = new Expenses();
                expense.setName("Cobrança - ".concat(String.valueOf(i)));
                expense.setValue(account.getValueInstallment());
                expense.setStatus("PAGO");
                expense.setConfigAccountId(account.getId());
                expenses.add(expense);
            }
            setExpenses(expenses);

        }
        return account;
    }

    public List<Expenses> setExpenses(List<Expenses> expenses) {
        return expensesRepository.saveAll(expenses);
    }

    public List<Expenses> getExpenses(Long configAccountId) {
        return expensesRepository.findAllByConfigAccountId(configAccountId);
    }
}
