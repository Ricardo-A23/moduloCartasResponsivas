package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;
import org.gobierno.carta.responsiva.proyecto.entities.enums.EstatusCarta;
import org.gobierno.carta.responsiva.proyecto.entities.enums.TipoAsignacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity()
@Table(name = "cartas_responsivas")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartaResponsiva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String folio;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @ManyToOne
    @JoinColumn(name = "usuario_recibe", nullable = false)
    private Usuario receptor; //del tipo Persona

    @Column(name = "tipo_asignacion", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAsignacion tipoAsignacion;

    @Column(length = 400)
    private String descripcion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstatusCarta estatus;

    @Column(nullable = false)
    private boolean firmada;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario responsable; //el que la crea

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaEmision = LocalDate.now();
        this.fechaCreacion = LocalDateTime.now();
        if(this.folio == null) {
            this.folio = "CR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
    }

}
