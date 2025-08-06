package org.gobierno.carta.responsiva.proyecto.entities.enums;

public enum EstatusCorreo {
    ACTIVO,            // Actualmente asignado y en uso
    INACTIVO,          // Ya no se usa, pero sigue en el sistema
    PENDIENTE_ENTREGA, // Aún no ha sido entregado a la persona
    DADO_DE_BAJA       // Eliminado o dado de baja del sistema
}
