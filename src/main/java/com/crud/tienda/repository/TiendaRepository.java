package com.crud.tienda.repository;

import com.crud.tienda.model.Tienda;

import java.util.List;

public interface TiendaRepository {
    public List<Tienda> findAll();
    public int save(Tienda tienda);
    public int update(Tienda tienda);
    public int deleteById(int id);
}
