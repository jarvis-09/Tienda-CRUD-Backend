package com.crud.tienda.service;

import com.crud.tienda.model.Tienda;
import com.crud.tienda.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TiendaService implements ITiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Override
    public List<Tienda> findAll() {
        List<Tienda> list;
        try{
            list = tiendaRepository.findAll();

        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }


    @Override
    public int save(Tienda tienda) {
        int row;

        try {
            row = tiendaRepository.save(tienda);
        }catch(Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Tienda tienda) {
        int row;

        try {
            row = tiendaRepository.update(tienda);
        }catch(Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;

        try{
            row = tiendaRepository.deleteById(id);
        }catch(Exception ex) {
            throw ex;
        }
        return row;
    }
}
