package com.crud.tienda.repository;

import com.crud.tienda.model.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CTiendaRepository implements TiendaRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Tienda> findAll() {
        String sql = "select * from productos WHERE status = 1";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tienda.class));
    }

    @Override
    public int save(Tienda tienda) {
        String sql = "INSERT INTO productos (nombre, valor, descripcion, status) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{tienda.getNombre(),tienda.getValor(),tienda.getDescripcion(),tienda.getStatus()});
    }

    @Override
    public int update(Tienda tienda) {
        String sql = "UPDATE productos SET nombre=?, valor=?, descripcion=? WHERE idProducto=?";
        return jdbcTemplate.update(sql, tienda.getNombre(), tienda.getValor(), tienda.getDescripcion(), tienda.getIdProducto());
    }

    @Override
    public int deleteById(int id) {
        String sql = "UPDATE productos SET status = 0 WHERE idProducto = ?";
        return jdbcTemplate.update(sql, id);
    }

}
