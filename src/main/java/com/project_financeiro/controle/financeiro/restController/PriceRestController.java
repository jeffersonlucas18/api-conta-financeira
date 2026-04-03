package com.project_financeiro.controle.financeiro.restController;

import com.project_financeiro.controle.financeiro.model.Category;
import com.project_financeiro.controle.financeiro.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
