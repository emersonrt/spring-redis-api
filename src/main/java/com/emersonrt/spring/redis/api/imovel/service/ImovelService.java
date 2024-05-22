package com.emersonrt.spring.redis.api.imovel.service;

import com.emersonrt.spring.redis.api.imovel.model.Imovel;
import com.emersonrt.spring.redis.api.imovel.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public List<Imovel> findAll() {
        List<Imovel> imovelList = imovelRepository.findAll();
        return imovelList;
    }

}
