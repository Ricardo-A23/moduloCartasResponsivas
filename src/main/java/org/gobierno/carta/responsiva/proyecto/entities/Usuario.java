package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String curp;
    private String puesto;
    private String area;
}
