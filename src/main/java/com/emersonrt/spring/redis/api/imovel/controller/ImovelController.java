package com.emersonrt.spring.redis.api.imovel.controller;

import com.emersonrt.spring.redis.api.imovel.model.Imovel;
import com.emersonrt.spring.redis.api.imovel.service.ImovelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("imoveis")
public class ImovelController {

    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping
    public ResponseEntity<List<Imovel>> findAll() {
        return ResponseEntity.ok(imovelService.findAll());
    }

    @GetMapping("{imovelId}")
    public ResponseEntity<Imovel> findById(@PathVariable Long imovelId) {
        return ResponseEntity.ok(imovelService.findById(imovelId));
    }

}
