package com.crud.tienda.model;

import lombok.Data;

@Data
public class Tienda {
    int idProducto;
    String nombre;
    int valor;
    String descripcion;
    int status;


}
