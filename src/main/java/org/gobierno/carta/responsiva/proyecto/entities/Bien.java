package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;
import org.gobierno.carta.responsiva.proyecto.entities.enums.EstadoFisico;
import org.gobierno.carta.responsiva.proyecto.entities.enums.EstatusBienes;

import java.time.LocalDate;


@Entity
@Table(name = "bienes")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String claveInventario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 200)
    private String marca;

    @Column(length = 100)
    private String modelo;

    @Column(length = 100)
    private String numeroSerie;

    @Column(length = 100)
    private String tipo; // Ej. Laptop, Impresora, Switch

    @Column(length = 400)
    private String descripcion;

    @Column(name = "fecha_adquisicion")
    private LocalDate fechaAdquisicion;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private EstadoFisico estadoFisico; // Ej. NUEVO, USADO, DETERIORADO

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private EstatusBienes estatus; // Ej. ASIGNADO, EN ALMACÉN, DADO DE BAJA

    @ManyToOne
    @JoinColumn(name = "carta_responsiva_id")
    private CartaResponsiva cartaResponsiva;



}
