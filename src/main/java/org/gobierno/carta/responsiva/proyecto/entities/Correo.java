package org.gobierno.carta.responsiva.proyecto.entities;

import jakarta.persistence.*;
import lombok.*;
import org.gobierno.carta.responsiva.proyecto.entities.enums.EstatusCorreo;

@Entity
@Table(name = "correos")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Correo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String correo; // Ej: usuario@dominio.gob.mx

    @Column(length = 100)
    private String proveedor; // Ej: Microsoft 365, Gmail, Zimbra

    @Column(length = 100)
    private String contrasenaTemporal; // Solo si es necesario entregarla

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private EstatusCorreo estatus; // ASIGNADO, EN ALMACÉN, DADO_DE_BAJA

    @ManyToOne
    @JoinColumn(name = "carta_responsiva_id", nullable = false)
    private CartaResponsiva cartaResponsiva;
}
