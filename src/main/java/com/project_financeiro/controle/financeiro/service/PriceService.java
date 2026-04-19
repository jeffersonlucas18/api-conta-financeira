package com.project_financeiro.controle.financeiro.service;

import com.project_financeiro.controle.financeiro.model.*;
import com.project_financeiro.controle.financeiro.model.view.ViewDetailAccount;
import com.project_financeiro.controle.financeiro.repository.*;
import com.project_financeiro.controle.financeiro.repository.view.ViewDetailAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private final CategoryRepository categoryRepository;
    private final ConfigAccountRepository configAccountRepository;
    private final ExpensesRepository expensesRepository;
    private final UserRepository userRepository;
    private final ViewDetailAccountRepository viewDetailAccountRepository;

    public PriceService(CategoryRepository categoryRepository, ConfigAccountRepository configAccountRepository, ExpensesRepository expensesRepository, UserRepository userRepository,ViewDetailAccountRepository viewDetailAccountRepository) {
        this.categoryRepository = categoryRepository;
        this.configAccountRepository = configAccountRepository;
        this.expensesRepository = expensesRepository;
        this.viewDetailAccountRepository = viewDetailAccountRepository;
        this.userRepository = userRepository;
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
        configAccount.setUserId(1L);
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

    public Optional<User> getUser() {
        return userRepository.findById(1L);
    }

    public List<ViewDetailAccount> getAccountsDetail() {
        return viewDetailAccountRepository.findAll();
    }
}
