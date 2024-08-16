package com.crud.tienda.service;

import com.crud.tienda.model.Tienda;

import java.util.List;

public interface ITiendaService {

    public List<Tienda> findAll();
    public int save(Tienda tienda);
    public int update(Tienda tienda);
    public int deleteById(int id);
}
