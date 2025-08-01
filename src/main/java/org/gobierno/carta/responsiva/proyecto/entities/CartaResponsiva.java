package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity()
@Table(name = "cartas_responsivas")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }

    public TipoAsignacion getTipoAsignacion() {
        return tipoAsignacion;
    }

    public void setTipoAsignacion(TipoAsignacion tipoAsignacion) {
        this.tipoAsignacion = tipoAsignacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstatusCarta getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusCarta estatus) {
        this.estatus = estatus;
    }

    public boolean isFirmada() {
        return firmada;
    }

    public void setFirmada(boolean firmada) {
        this.firmada = firmada;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
