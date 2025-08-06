package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicios_tic")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServicoTic{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreServicio;

    private String descripcion;

}
