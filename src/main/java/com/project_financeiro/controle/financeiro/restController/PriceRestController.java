package com.project_financeiro.controle.financeiro.restController;

import com.project_financeiro.controle.financeiro.model.*;
import com.project_financeiro.controle.financeiro.model.view.ViewDetailAccount;
import com.project_financeiro.controle.financeiro.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/control-price")
@Tag(name = "Conta", description ="Requisições utilizadas!")
public class PriceRestController {

    private final PriceService priceService;


    public PriceRestController(PriceService priceService) {
        this.priceService = priceService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categories.json")
    @Operation(summary = "Categorias", description = "Retorna uma listagem de categorias!")
    public List<Category> getCategories() {
        return priceService.getAllCategories();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user.json")
    @Operation(summary = "Usuário", description = "Retorna somente um usuário!")
    public Optional<User> getUser() {
        return priceService.getUser();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/accounts.json")
    @Operation(summary = "Contas", description = "Retorna uma listagem de contas configuradas!")
    public List<ConfigAccount> getAccounts() {
        return priceService.getAccounts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/account/details.json")
    @Operation(summary = "Detalhes da contas", description = "Retorna uma listagem detalhadas das contas cadastradas!")
    public List<ViewDetailAccount> getAccountsDetail() {
        return priceService.getAccountsDetail();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/account/{id}.json")
    @Operation(summary = "Conta especifica", description = "Retorna a conta via id(indentificador)!")
    public Optional<ConfigAccount> getAccount(@PathVariable Long id) {
        return priceService.getAccount(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/account/save.json")
    @Operation(summary = "Salva a conta", description = "Cadastra uma nova configuração de conta!")
    public ConfigAccount setAccount(@Valid @RequestBody  ConfigAccount configAccount) {
        return priceService.setAccount(configAccount);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/expense/save.json")
    @Operation(summary = "Salva as despesas", description = "Cadastra uma listagem de despesas para a configuração de conta!")
    public List<Expenses> setExpenses(@Valid @RequestBody List<Expenses> expenses) {
        return priceService.setExpenses(expenses);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/expense/expenses.json")
    @Operation(summary = "Despesas", description = "Retorna uma lista de despesas!")
    public List<Expenses> getExpenses(@RequestParam Long configAccountId) {
        return priceService.getExpenses(configAccountId);
    }
}

