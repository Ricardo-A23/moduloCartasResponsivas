package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;
import org.gobierno.carta.responsiva.proyecto.entities.enums.EstatusCarta;

import java.time.LocalDateTime;

@Entity
@Table(name = "cartas_servicios_tic")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartaServicioTic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "responsable_id", nullable = false)
    private Usuario responsableAsignado;

    @ManyToOne
    @JoinColumn(name = "carta_responsiva_id", nullable = false)
    private CartaResponsiva cartaResponsiva;

    @ManyToOne
    @JoinColumn(name = "servicio_tic_id", nullable = false)
    private ServicoTic servicoTic;

    @Column(name = "estatus_servicio", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstatusCarta estatusServicio;

    @Column(name = "fecha_terminacion")
    private LocalDateTime fechaTerminacion;

    @Column(length = 400)
    private String observaciones;

}
