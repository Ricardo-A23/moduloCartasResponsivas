package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "cartas_aplicaciones")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartaAplicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Carta responsiva que documenta la entrega/asignación
    @ManyToOne
    @JoinColumn(name = "carta_responsiva_id", nullable = false)
    private CartaResponsiva cartaResponsiva;

    // Aplicación asignada
    @ManyToOne
    @JoinColumn(name = "aplicacion_id", nullable = false)
    private Aplicacion aplicacion;

    // Usuario responsable de utilizar la aplicación
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuarioResponsable;

    // Estado del acceso: Activo, Revocado, Pendiente, etc.
    @Column(name = "estatus_acceso", nullable = false, length = 50)
    private String estatusAcceso;

    @Column(name = "usuario_acceso", length = 100)
    private String usuarioAcceso;

    @Column(name = "contrasena_acceso", length = 100)
    private String contrasenaAcceso;

    // Fecha en que se otorgó el acceso o asignación
    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;

    // Comentarios o notas específicas sobre esta asignación
    @Column(length = 400)
    private String observaciones;


}
