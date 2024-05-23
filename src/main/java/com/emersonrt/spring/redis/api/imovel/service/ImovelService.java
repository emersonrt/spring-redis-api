package com.emersonrt.spring.redis.api.imovel.service;

import com.emersonrt.spring.redis.api.exceptions.NotFoundException;
import com.emersonrt.spring.redis.api.imovel.model.Imovel;
import com.emersonrt.spring.redis.api.imovel.repository.ImovelRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    @Cacheable(value = "imoveis")
    public List<Imovel> findAll() {
        List<Imovel> imovelList = imovelRepository.findAll();
        if (imovelList.isEmpty()) {
            throw new NotFoundException("Nenhum imóvel encontrado");
        }
        return imovelList;
    }

    @Cacheable(value = "imoveis", key = "#imovelId")
    public Imovel findById(Long imovelId) {
        return imovelRepository.findById(imovelId)
                .orElseThrow(() -> new NotFoundException("Imóvel não encontrado"));
    }
}
