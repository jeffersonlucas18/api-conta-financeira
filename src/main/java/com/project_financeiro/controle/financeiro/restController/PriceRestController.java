package com.project_financeiro.controle.financeiro.restController;

import com.project_financeiro.controle.financeiro.model.Category;
import com.project_financeiro.controle.financeiro.model.ConfigAccount;
import com.project_financeiro.controle.financeiro.service.PriceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/control-price")
public class PriceRestController {

    private final PriceService priceService;

    public PriceRestController(PriceService priceService) {
        this.priceService = priceService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categories.json")
    public List<Category> getCategories() {
        return priceService.getAllCategories();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/accounts.json")
    public Page<ConfigAccount> getAccounts(Pageable pageable) {
        return priceService.getAccounts(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/account/{id}.json")
    public Optional<ConfigAccount> getAccount(@PathVariable Long id) {
        return priceService.getAccount(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/account/save.json")
    public ConfigAccount setAccount(@RequestBody ConfigAccount configAccount) {
        return priceService.setAccount(configAccount);
    }
}

