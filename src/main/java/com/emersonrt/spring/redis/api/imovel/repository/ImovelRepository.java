package com.emersonrt.spring.redis.api.imovel.repository;

import com.emersonrt.spring.redis.api.imovel.model.Imovel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ImovelRepository {

    private final JdbcTemplate jdbcTemplate;

    public ImovelRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Imovel> findAll() {
        return jdbcTemplate.query("SELECT * FROM imovel", new ImovelRowMapper());
    }

    public Optional<Imovel> findById(Long imovelId) {
        String sql = "SELECT * FROM imovel WHERE id = ?";
        try {
            Imovel imovel = jdbcTemplate.queryForObject(sql, new Object[]{imovelId}, new ImovelRowMapper());
            return Optional.ofNullable(imovel);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private static class ImovelRowMapper implements RowMapper<Imovel> {
        @Override
        public Imovel mapRow(ResultSet rs, int rowNum) throws SQLException {
            Imovel imovel = new Imovel();
            imovel.setId(rs.getLong("id"));
            imovel.setEndereco(rs.getString("endereco"));
            imovel.setPreco(rs.getBigDecimal("preco"));
            imovel.setArea(rs.getBigDecimal("area"));
            return imovel;
        }
    }

}
