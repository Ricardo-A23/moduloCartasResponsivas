package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="aplicaciones")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Aplicacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique=true)
    private String nombre;

    @Column(length = 400)
    private String descripcion;

    @Column(length = 200)
    private String urlAcceso;

    private String version;
}
